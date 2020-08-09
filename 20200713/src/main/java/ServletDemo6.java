import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;

public class ServletDemo6 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.先获取session，如果用户曾经没有访问过，此时将创建新的session
        //如果已经访问过，就获取到曾经的session次数+1
        HttpSession httpSession = req.getSession(true);
        int count = 1;
        if (httpSession.isNew()) {
            httpSession.setAttribute("count",count);
        } else {
            count = (Integer)httpSession.getAttribute("count");
            count = count +1;
            httpSession.setAttribute("count",count);
        }
        resp.setContentType("text/html;charset=utf-8");
        Writer writer = resp.getWriter();
        writer.write("count : " + count);
    }
}
