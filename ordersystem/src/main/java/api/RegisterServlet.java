package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private Gson gson = new GsonBuilder().create();

    //读取的json请求对象
    static class Request {
        public String name;
        public String password;
    }

    //够早的json响应对象
    static class Response {
        public int ok;
        public String reason;
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.读取body中的数据
        //2.把body数据解析成Request对象
        //3.查询数据库，看看当前的用户名是否存在(如果存在，就提示已经被注册了)
        //4.把提交的用户名密码构造成User对象，插入数据库
        //5.构造响应数据。

        //1.

    }
}
