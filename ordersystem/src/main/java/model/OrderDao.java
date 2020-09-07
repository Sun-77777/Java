package model;

import exception.OrderSystemException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//1.新增订单
//2.查看所有订单(管理员 商家)
//3.查看指定用户的订单（普通用户，顾客）
//4.查看订单的详细信息
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
        String sql = "insert into orderDish values (?,?)";
        try {
            conn.setAutoCommit(false);
            //关闭自动提交。默认是自动提交的，调用executeXXX就自动把请求sql发给服务器
            ps = conn.prepareStatement(sql);

            //由于一个订单对应到多个菜品，就需要 遍历Order 中包含的菜品数组，把每个记录都取出来
            List<Dish> dishes = order.getDishes();
            for (Dish dish : dishes) {
                ps.setInt(1,order.getOrderId());
                ps.setInt(2,order.getUserId());
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
        String sql = "delete form order_user where orderId = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,orderId);
            int ret = ps.executeUpdate();
            if (ret != 1) {
                throw new OrderSystemException("回滚失败");
            }
            System.out.println("回滚成功") ;
        } catch (SQLException e) {
            e.printStackTrace();
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
    //3.查看指定用户的订单（普通用户，顾客）
    //4.查看订单的详细信息
    //5.修改订单状态(订单是否已经完成)

    public static void main(String[] args) {
        OrderDao orderDao = new OrderDao();
        Order order = new Order();

    }
}
