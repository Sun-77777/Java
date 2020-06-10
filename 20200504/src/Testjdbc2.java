import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Testjdbc2 {
    public static void main(String[] args) throws SQLException {
        //1.先创建DataSource 对象
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java_0601?characterEncoding=utf-8&useSSL=true");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("root");

        //2.创建Connection 对象，和数据库建立连接
        Connection connection = dataSource.getConnection();

        //3.借助PrepareStatement拼装Sql语句
        String sql = "select * from student";
        PreparedStatement statement = connection.prepareStatement(sql);

        //4.执行sql语句
        ResultSet resultSet = statement.executeQuery();

        //5.遍历结果集。 插入没有结果集，但是select有结果集,相当于一张表
        //遍历过程和使用迭代器遍历集合类有点像
        while (resultSet.next()) {
            //当前表中的每一行包含三个列，ID，name，classId,可以根据列名来获取对应的列数据
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int classId = resultSet.getInt("classId");
            System.out.println("id:" + id + " name:" + name + " classId:" + classId);
        }

        //6.关闭释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }

}
