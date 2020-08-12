package dao;

import entity.User;
import util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public User login(User loginUser) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        User user = null;

        try {
            String sql = "select * from user where username = ? and password = ?";
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,loginUser.getUsername());
            ps.setString(2,loginUser.getPassword());
            rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setAge(rs.getInt("age"));
                user.setGender(rs.getString("gender"));
                user.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(conn,ps,rs);
        }
        return user;
    }

    public void register(User newUser) {
        Connection conn = null;
        PreparedStatement ps = null;


        try {
            String sql = "insert into user values (null,?,?,?,?,?)";
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,newUser.getUsername());
            ps.setString(2,newUser.getPassword());
            ps.setInt(3,newUser.getAge());
            ps.setString(4,newUser.getGender());
            ps.setString(5,newUser.getEmail());
            int ret = ps.executeUpdate();
            if (ret == 1) {
                System.out.println("注册成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(conn,ps,null);
        }

    }

    public static void main(String[] args) {
        /*User user = new User();
        user.setUsername("bit");
        user.setPassword("123");
        User loginUser = login(user);
        System.out.println(loginUser);*/
    }
}
