package model;

import exception.OrderSystemException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//1.新增订单
//2.查看所有订单(管理员 商家)()先不考虑详细菜品信息
//3.查看指定用户的订单（普通用户，顾客）
//4.查看指定订单的详细信息
//5.修改订单状态(订单是否已经完成)
public class OrderDao {
    //1.新增订单
    //订单是和两个表关联的
    //第一个表order_user
    //第二个表order_dish,一个订单中可能会涉及多个菜，就需要给这个表一次性插入多个纪录
    public void add(Order order) throws OrderSystemException {
        //1.先操作order_user表
        addOrderUser(order);
        //2.再操作order_dish表
        addOrderDish(order);
    }

    //把菜品信息给插入到表order_dish中
    //插入的时候就需要同时知道orderId userId
    private void addOrderDish(Order order) throws OrderSystemException {
        //1.获取数据库连接
        //2.拼装sql
        //3.关闭自动连接
        //4.遍历dishes给sql添加多个values

        Connection conn = null;
        PreparedStatement ps = null;

        conn = DBUtil.getConnection();
        String sql = "insert into order_dish values (?,?)";
        try {
            conn.setAutoCommit(false);
            //关闭自动提交。默认是自动提交的，调用executeXXX就自动把请求sql发给服务器
            ps = conn.prepareStatement(sql);

            //由于一个订单对应到多个菜品，就需要 遍历Order 中包含的菜品数组，把每个记录都取出来
            List<Dish> dishes = order.getDishes();
            for (Dish dish : dishes) {
                ps.setInt(1,order.getOrderId());
                ps.setInt(2,dish.getDishId());
                ps.addBatch();//给sql新增一个片段
            }
            ps.executeBatch();//把刚才的sql进行执行(不是真正的执行)
            conn.commit();//真正执行(发送给服务器)
            //手动关闭autoCommit就可以一次给服务器发送多个sql来执行了。

        } catch (SQLException e) {
            e.printStackTrace();
            //如果上面的操作出现异常，就认为整体的新增订单操作失败，回滚之前的插入order_user表的内容
            deleteOrderUser(order.getOrderId());
        } finally {
            DBUtil.close(conn,ps,null);
        }
        System.out.println("插入订单成功");
    }
    //这个方法用于删除order_user表中的记录
    private void deleteOrderUser(int orderId) throws OrderSystemException {
        Connection conn = null;
        PreparedStatement ps = null;

        conn = DBUtil.getConnection();
        String sql = "delete from order_user where orderId = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,orderId);
            int ret = ps.executeUpdate();
            if (ret != 1) {
                throw new OrderSystemException("回滚失败");
            }
            System.out.println("回滚成功") ;
        } catch (SQLException e) {
            throw new OrderSystemException("回滚失败");
        } finally {
            DBUtil.close(conn,ps,null);
        }

    }

    private void addOrderUser(Order order) throws OrderSystemException {
        //1.先获取数据库连接
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = DBUtil.getConnection();
        //2.构造sql
        String sql = "insert into order_user(userId,time,isDone) values(?,now(),0)";//0未完结
        try {
            ps = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            //插入完毕的同时就会把数据库自动生成的自增主键的值获得
            ps.setInt(1,order.getUserId());
            //3.执行sql
            int ret = ps.executeUpdate();
            if (ret != 1) {
                throw  new OrderSystemException("插入订单失败");
            }
            //把自增主键的值给读取出来
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                //理解参数 1.读取resultSet的结果时，可以使用列名，也可以使用下标
                //由于一个表中的自增列有多个，返回的时候都返回回来了。下标填成1
                //就表示想获取第一个自增列生成的值。
                order.setOrderId(rs.getInt(1));
            }
            System.out.println("插入订单第一步成功");
        } catch (SQLException e) {
            e.printStackTrace();
            throw  new OrderSystemException("插入订单失败");
        } finally {
            DBUtil.close(conn,ps,rs);
        }
    }


    //2.查看所有订单(管理员 商家)
    //Order对象里，有一些orderId,userId这些属性，直接借助order_user表就获取到了
    //还有一个重要的属性，dishes(List<Dish>)
    //详细信息需要现根据order_dish表，获取到所有相关的dishID，然后在根据dishId去dishes表中查。
    //仔细思考，可以发现，这里的订单获取 不需要获取那么详细的内容，只获取到订单的一些基本信息就行了。
    //菜品信息，反正有一个查看指定订单详细信息的接口
    //当前这个接口返回的Order对象，不包含dishes详细数据的
    //这样做是为了让代码更简单，更高效.
    public List<Order> selectAll() {
        List<Order> orders = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        conn = DBUtil.getConnection();
        String sql = "select * from order_user";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setOrderId(rs.getInt("orderId"));
                order.setUserId(rs.getInt("userId"));
                order.setTime(rs.getTimestamp("time"));
                order.setIsDone(rs.getInt("isDone"));
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn,ps,rs);
        }
        return orders;
    }
    //3.查看指定用户的订单（普通用户，顾客）
    public List<Order> selectByUserId(int userId) {
        List<Order> orders = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        conn = DBUtil.getConnection();
        String sql = "select * from order_user where userId = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setOrderId(rs.getInt("orderId"));
                order.setUserId(rs.getInt("userId"));
                order.setTime(rs.getTimestamp("time"));
                order.setIsDone(rs.getInt("isDone"));
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn,ps,rs);
        }
        return orders;
    }
    //4.查看订单的详细信息
    //在这个方法中就要把这个Order 对象完整的填写进去。
    //包括Order中有哪些的菜品，以及菜品的详情
    //此处的操作，使用的是多次查询的方式完成的
    //除此之外，也可以使用多表查询来完成。(sql语句会更复杂，但是java代码会更简单一些)
    public Order selectById(int orderId) throws OrderSystemException {
        //1.现根据orderId 得到一个Order对象
        Order order = buildOrder(orderId);
        //2.根据orderId 得到该orderId对应的菜品id列表
        List<Integer> dishIds = selectDishIds(orderId);
        //3.根据菜品id 列表，查询dishes表，获取到菜品详情
        order = getDishDetail(order,dishIds);
        return order;
    }
    //
    private Order getDishDetail(Order order, List<Integer> dishIds) throws OrderSystemException {
        //1.转备好要返回的结果
        List<Dish> dishes = new ArrayList<>();
        //2.遍历dishIds 在dishes表中查。(前面已经有现成的方法了，直接调用)
        DishDao dishDao = new DishDao();
        for (Integer dishId : dishIds) {
            Dish dish = dishDao.selectById(dishId);
            dishes.add(dish);
        }
        order.setDishes(dishes);
        return order;
    }
    //
    private List<Integer> selectDishIds(int orderId) {
        List<Integer> dishIds = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = DBUtil.getConnection();
        String sql = "select * from order_dish where orderId = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,orderId);
            rs = ps.executeQuery();
            while (rs.next()) {
                dishIds.add(rs.getInt("dishId"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn,ps,rs);
        }
        return dishIds;
    }

    //根据orderId 来查询对应的Order 对象的基本信息
    private Order buildOrder(int orderId) {
        Order order = new Order();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        conn = DBUtil.getConnection();
        String sql = "select * from order_user where orderId = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,orderId);
            rs = ps.executeQuery();
            if (rs.next()) {
                order.setOrderId(rs.getInt("orderId"));
                order.setUserId(rs.getInt("userId"));
                order.setTime(rs.getTimestamp("time"));
                order.setIsDone(rs.getInt("isDone"));
                return order;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn,ps,rs);
        }
        return null;
    }
    //5.修改订单状态(订单是否已经完成)
    public void changeState(int orderId,int isDone) throws OrderSystemException {
        Connection conn = null;
        PreparedStatement ps = null;

        conn = DBUtil.getConnection();
        String sql = "update order_user set isDone = ? where orderId = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,isDone);
            ps.setInt(2,orderId);
            int ret = ps.executeUpdate();
            if (ret != 1) {
                throw new OrderSystemException("修改订单状态失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("修改订单状态失败");
        } finally {
            DBUtil.close(conn,ps,null);
        }
    }

    public static void main(String[] args) {
        OrderDao orderDao = new OrderDao();
        Order order = new Order();

    }
}
