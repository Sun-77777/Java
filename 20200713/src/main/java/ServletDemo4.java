import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//Cookie :字符串，客户端保存数据的一种方式。
//服务器通过set-cookie 字段返回的内容。
//浏览器按照域名/地址，分别存储，组织成键值对的结构
//下次请求中，通过请求中的Cookie字段自动把Cookie数据带到服务器端了。
//Session:服务器存储数据的一种方式。
//也是通过键值对的方式来组织的，key就是sessionid,value就是一个具体的session。（Session 中又可以包含一些用户自定制的内容）
public class ServletDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.先构造Cookie对象，每个Cookie

    }
}
