package model;

import exception.OrderSystemException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    //1.插入用户：注册的时候使用
    public void add(User user) throws OrderSystemException {
        Connection conn = null;
        PreparedStatement ps = null;

        conn = DBUtil.getConnection();
        String sql = "insert into user values(null,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,user.getName());
            ps.setString(2,user.getPassword());
            ps.setInt(3,user.getIsAdmin());
            int ret = ps.executeUpdate();
            if (ret != 1) {
                throw new OrderSystemException("插入用户失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("插入用户失败");
        } finally {
            DBUtil.close(conn,ps,null);
        }
        System.out.println("插入用户成功");
    }
    //2.按名字查找用户：登录的时候使用
    public User selectByName(String name) throws OrderSystemException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        conn = DBUtil.getConnection();
        String sql = "select * from user where name = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("userId"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setIsAdmin(rs.getInt("isAdmin"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("按名字查找失败");
        }
        return null;
    }
    //3.按照用户ID查找：展示信息时使用
    public User selectById(int userId) throws OrderSystemException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        conn = DBUtil.getConnection();
        String sql = "select * from user where userId = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,userId);
            rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("userId"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setIsAdmin(rs.getInt("isAdmin"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("按照用户ID查找失败");
        } finally {
            DBUtil.close(conn,ps,rs);
        }
        return null;
    }



}
