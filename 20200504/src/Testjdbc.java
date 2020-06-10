import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Testjdbc {
    public static void main(String[] args) throws SQLException {
        //1.创建dataSource 对象
        //主要配置url,root,password
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java_0601? characterEncoding = utf-8&setSSL = true");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("root");

        //2.和数据库建立连接，建立连接好了以后就可以进行后续的数据传输了。
        //建立连接的意义是为了验证当前的网络通信是否正常。
        //如果不正常就会抛出SQLException异常。
        Connection connection = dataSource.getConnection();

        //3.拼装sql语句，用到PrepareStatement对象。
        int id = 1;
        String name = "曹操";
        int classId = 10;
        String sql = "insert into student values(?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,id);
        statement.setString(2,name);
        statement.setInt(3,classId);
        System.out.println("statement:" + statement);

        //4。拼装完比以后，可以执行sql了。
        //insert delete update 都使用executeUpdate方法来执行。
        //select 就使用executeQuery来执行。
        //返回值表示此次操作修改了多少行。
        int ret = statement.executeUpdate();
        System.out.println("ret:" + ret);

        //5.执行完毕之后，关闭释放相关资源
        //一定是后创建的先被关闭。
        statement.close();
        connection.close();

    }
}
