package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OrderDao {
    //查看所有订单(管理员 普通用户)
    //新增订单
    //查看指定用户的订单（普通用户）
    //查看订单的详细信息
    //修改订单状态
    public void add(Order order) {
        Connection conn = null;
        PreparedStatement PS = null;
        ResultSet rs = null;

        conn = DBUtil.getConnection();
        String sql = "insert into order_user(userId,time,isDone) values (?,now(),?)";

    }
}
