package model;

import com.mysql.jdbc.Connection;

public class UserDao {
    void add(User user) {
        Connection connection = DBUtil.getConnection();
        String sql = "insert into user values(null,?,?)";

    }
}
