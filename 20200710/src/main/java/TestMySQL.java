import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestMySQL {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/java16?characterEncoding=utf-8&useSSL=true";
        String username = "root";
        String password = "root";

        //1.创建DataSource 实例
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL(url);
        ((MysqlDataSource)dataSource).setUser(username);
        ((MysqlDataSource)dataSource).setPassword(password);

        //2.和数据库建立连接
        Connection connection = dataSource.getConnection();
        //3.访问数据库，需要先拼装一个sql语句
        String sql = "select * from student";
        PreparedStatement statement = connection.prepareStatement(sql);

        //执行sql
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("id"));
            System.out.println(resultSet.getString("name"));
            System.out.println(resultSet.getInt("score"));
        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}
