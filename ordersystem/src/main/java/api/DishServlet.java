package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import exception.OrderSystemException;
import exception.OrderSystemUtil;
import model.Dish;
import model.DishDao;
import model.Order;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/dish")
public class DishServlet extends HttpServlet {
    private Gson gson = new GsonBuilder().create();

    static class Request {
        public String name;
        public int price;
    }
    static class Response {
        public int ok;
        public String reason;
    }

    /**
     * 新增菜品
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Response response = new Response();
        try {
            //1.检查用户的登录状态
            HttpSession session = req.getSession(false);
            if (session == null) {
                throw new OrderSystemException("当前并未登录");
            }
            User user = (User)session.getAttribute("user");
            if (user == null) {
                throw new OrderSystemException("当前并未登录");
            }
            //2.检查用户是否是管理员
            if (user.getIsAdmin() == 0) {
                throw new OrderSystemException("您不是管理员");
            }
            //3.读取请求body
            String body = OrderSystemUtil.readBody(req);
            //4.把body转成Request对象
            Request request = gson.fromJson(body,Request.class);
            //5.构造Dish对象，插入到数据库中.
            DishDao dishDao = new DishDao();
            Dish dish = new Dish();
            dish.setName(request.name);
            dish.setPrice(request.price);
            dishDao.add(dish);
            //6.返回结果给客户端
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

    /**
     * 删除菜品
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Response response = new Response();
        try {
            //1.检查用户是否登录
            HttpSession  session = req.getSession(false);
            if (session == null) {
                throw new OrderSystemException("您尚未登录");
            }
            User user = (User)session.getAttribute("user");
            if (user == null) {
                throw new OrderSystemException("您尚未登录");
            }
            //2.检查用户是否是管理员
            if (user.getIsAdmin() == 0) {
                throw new OrderSystemException("您不是管理员");
            }
            //3.读取到dishId
            String dishIdStr = req.getParameter("dishId");
            if (dishIdStr == null) {
                throw new OrderSystemException("dishId参数不正确");
            }
            int dishId = Integer.parseInt(dishIdStr);
            //4.删除数据库中的对应记录
            DishDao dishDao = new DishDao();
            dishDao.delete(dishId);
            //5.返回一个响应结果
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

    /**
     * 查看所有菜品
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Response response = new Response();
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        try {
            //1.检测登录状态
            HttpSession session = req.getSession(false);
            if (session == null) {
                throw new OrderSystemException("您尚未登录");
            }
            User user = (User) session.getAttribute("user");
            if (user == null) {
                throw new OrderSystemException("您尚未登录");
            }
            //2.从数据库中读取数据
            DishDao dishDao = new DishDao();
            List<Dish> dishes = dishDao.selectAll();
            //3.把结果返货到页面即可
            String jsonString = gson.toJson(dishes);
            resp.getWriter().write(jsonString);
        } catch (OrderSystemException e) {
            response.ok = 0;
            response.reason = e.getMessage();
            String jsonString = gson.toJson(response);
            resp.getWriter().write(jsonString);
        }
    }
}
