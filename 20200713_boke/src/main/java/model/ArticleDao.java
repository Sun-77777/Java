package model;

import com.mysql.jdbc.Connection;

public class ArticleDao {
    //1.新增文章
    public void add(Article article) {
        //1.获取数据库连接
        Connection connection = DBUtil.getConnection();
        String sql = "insert into article values(null,?,?,?)";
        
        //2.构造SQL
        //3.执行SQL
        //4.释放连接

    }
    //2.查看文章列表
    //3.查看指定文章详情
    //4.删除指定文章

}
