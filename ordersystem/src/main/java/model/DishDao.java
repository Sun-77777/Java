package model;

import exception.OrderSystemException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DishDao {
    /**
     *新增菜品
     * @param dish
     */
    public void add(Dish dish) throws OrderSystemException {
        Connection conn = null;
        PreparedStatement ps = null;

        conn = DBUtil.getConnection();
        String sql = "insert into dishes(name,price) values (?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,dish.getName());
            ps.setInt(2,dish.getPrice());
            int ret = ps.executeUpdate();
            if (ret != 1) {
                throw new OrderSystemException("新添菜品失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn,ps,null);
        }
        System.out.println("新添菜品成功");
    }

    /**
     * 删除菜品
     * @param dishId
     * @return
     */
    public int delete(int dishId) throws OrderSystemException {
        Connection conn = null;
        PreparedStatement ps = null;

        conn = DBUtil.getConnection();
        String sql = "delete from dishes where dishId = ?";
        int ret = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,dishId);
            ret = ps.executeUpdate();
            if (ret != 1) {
                throw new OrderSystemException("删除菜品失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn,ps,null);
        }
        return ret;
    }

    /**
     * 查找所有菜品
     * @return
     */
    public List<Dish> selectAll() {
        List<Dish> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        conn = DBUtil.getConnection();
        String sql = "select * from dishes";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Dish dish = new Dish();
                dish.setDishId(rs.getInt("dishId"));
                dish.setName(rs.getString("name"));
                dish.setPrice(rs.getInt("price"));
                list.add(dish);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn,ps,rs);
        }
        return list;
    }

    /**
     * 按照id查找菜品
     * @param dishId
     * @return
     */
    public Dish selectById(int dishId) throws OrderSystemException {
        Dish dish = new Dish();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        conn = DBUtil.getConnection();
        String sql = "select * from dishes where dishId = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,dishId);
            rs = ps.executeQuery();
            if (rs.next()) {
                dish.setDishId(rs.getInt("dishId"));
                dish.setName(rs.getString("name"));
                dish.setPrice(rs.getInt("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("根据ID查找失败");
        } finally {
            DBUtil.close(conn,ps,rs);
        }
        return dish;
    }

    public static void main(String[] args) throws OrderSystemException {
        DishDao dishDao = new DishDao();
        List<Dish> list = new ArrayList<>();
        list = dishDao.selectAll();
        System.out.println(list);
        /*int ret = dishDao.delete(1);
        System.out.println(ret);*/
        /*Dish dish = new Dish();
        dish.setName("红烧肉");
        dish.setPrice(5000);
        dishDao.add(dish);*/
    }
}
