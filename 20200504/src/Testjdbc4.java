import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Testjdbc4 {
    public static void main(String[] args) throws SQLException {
        System.out.println("请输入要修改的id：");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        System.out.println("请输入要修改的名字");
        String name = scanner.next();
        //1.
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java_0601?characterEncoding=utf-8&useSSL=true");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("root");

        //2.
        Connection connection = dataSource.getConnection();

        //3.
        String sql = "update student set name = ? where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,name);
        statement.setInt(2,id);

        //4.
        int ret = statement.executeUpdate();
        if (ret == 1) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }

        //5.
        statement.close();
        connection.close();
    }
}
