package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Map<String,Object> return_map = new HashMap<>();
        if(username.equals("") || password.equals("")) {
            return_map.put("msg",false);
        }else {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            UserService userService = new UserService();
            String name = userService.ifExistUser(username);
            if (name == null) {
                return_map.put("msg", true);
                userService.register(user);
            } else {
                return_map.put("msg", false);
            }
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(),return_map);
    }
}
