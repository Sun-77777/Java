import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Testjdbc3 {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要删除的名字");
        String name = scanner.nextLine();
        //1.
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java_0601?character=ytf-8&useSSL=true");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("root");
        //2.
        Connection connection = dataSource.getConnection();
        //3.
        String sql = "delete from student where name = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,name);

        //4.
        int ret = statement.executeUpdate();
        if (ret == 1) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }

        //5.
        statement.close();
        connection.close();
    }
}
