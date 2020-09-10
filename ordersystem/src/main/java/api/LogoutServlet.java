package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import exception.OrderSystemException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    private Gson gson = new GsonBuilder().create();
    static class Response {
        public int ok;
        public String reason;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Response response = new Response();
        try {
            //1.根据sessionId找对应的session对象
            HttpSession session = req.getSession(false);
            if (session == null) {
                throw new OrderSystemException("当前并未登录");
            }

            //2.把session对象中存的user信息给删掉即可(直接删掉session中的对应的键值对也行)
            session.removeAttribute("user");
            response.ok = 1;
            response.reason = "";
        } catch (OrderSystemException e) {
            response.ok = 0;
            response.reason = e.getMessage();
        } finally {
            resp.setContentType("application/json;charset=utf-8");
            String jsonString = gson.toJson(response);
            resp.getWriter().write(jsonString);
        }

    }
}
