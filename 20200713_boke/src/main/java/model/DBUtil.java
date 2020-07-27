package model;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
//管理数据库连接
//1.建立连接  2.关闭连接
//DataSource 每个应用程序只应该有一个实例（单例）
//DBUtil 本质上就是实现了一个单例模式，管理了唯一的一个DataSource实例
//单例模式 的实现由两种分格：1.懒汉模式 2.饿汉模式
public class DBUtil {
    //懒汉模式
    private static volatile DataSource dataSource = null;
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/20200713?characterEncoding=utf-8&useSSL=true";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    //如何保证线程安全？
    //1.加锁  2.双重if       3.关键字volatile
    public static DataSource getDataSource() {
        if (dataSource == null) {
            synchronized (DBUtil.class) {
                if (dataSource == null) {
                    dataSource = new MysqlDataSource();
                    ((MysqlDataSource)dataSource).setURL(URL);
                    ((MysqlDataSource)dataSource).setUser(USERNAME);
                    ((MysqlDataSource)dataSource).setPassword(PASSWORD);
                }
            }
        }
        return dataSource;
    }

    //
    public static Connection getConnection() {
        try {
            return (Connection) getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
