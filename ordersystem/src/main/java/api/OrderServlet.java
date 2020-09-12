package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import exception.OrderSystemException;
import exception.OrderSystemUtil;
import model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {
    private Gson gson = new GsonBuilder().create();
    static class Response {
        public int ok;
        public String reason;
    }

    /**
     * 新增订单(普通用户才能增加，管理员不能新增)
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
            //1.检查用户登录状态
            HttpSession session = req.getSession(false);
            if (session == null) {
                throw new OrderSystemException("您尚未登录");
            }
            User user = (User) session.getAttribute("user");
            if (user == null) {
                throw new OrderSystemException("您尚未登录");
            }
            //2.判断用户是否是管理员
            if (user.getIsAdmin() == 1) {
                throw new OrderSystemException("您是管理员");
            }
            //3。读取body中的数据，进行解析
            String body = OrderSystemUtil.readBody(req);
            //4.按照json格式解析
            Integer[] dishIds = gson.fromJson(body,Integer[].class);
            //List<Integer> dishes = gson.fromJson(body,new TypeToken<List<Integer>>(){}.getType());
            //5.构造订单对象
            Order order = new Order();
            order.setUserId(user.getUserId());
            List<Dish> dishes = new ArrayList<>();
            for (Integer dishId : dishIds) {
                DishDao dishDao = new DishDao();
                Dish dish = new Dish();
                dish = dishDao.selectById(dishId);
                dishes.add(dish);
            }
            order.setDishes(dishes);
            OrderDao orderDao = new OrderDao();
            orderDao.add(order);
            //6.把order对象插入到数据库中
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
     * 查看所有订单
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        Response response = new Response();
        try {
            //1.验证用户登录状态
            HttpSession session = req.getSession(false);
            if (session == null) {
                throw new OrderSystemException("您尚未登录");
            }
            User user = (User)session.getAttribute("user");
            if (user == null) {
                throw new OrderSystemException("您尚未登录");
            }
            //2.判断用户是管理员还是普通用户
            //3.读取orderId字段，看字段是否存在
            String orderIdStr = req.getParameter("orderId");
            OrderDao orderDao = new OrderDao();
            if (orderIdStr == null) {
                //4.查找数据库
                List<Order> orders = null;
                if (user.getIsAdmin() == 1) {
                    orders = orderDao.selectAll();
                } else {
                    orders = orderDao.selectByUserId(user.getUserId());
                }
                //5.构造响应结果
                String jsonString = gson.toJson(orders);
                resp.getWriter().write(jsonString);
            } else {
                //4.查找数据库，查找指定订单
                int orderId = Integer.parseInt(orderIdStr);
                Order order = orderDao.selectById(orderId);

                // 如果是普通用户，查找时发现自身的userId和订单的userId不相符
                //这就返回一个出错数据。
                //如果是管理员，才允许查看所有用户的订单.
                if (user.getIsAdmin() == 0 && user.getUserId() != order.getUserId()) {
                    throw new OrderSystemException("当时您无权查看其他人的订单");
                }
                //5.构造响应结果
                String jsonString = gson.toJson(order);
                resp.getWriter().write(jsonString);
            }
        } catch (OrderSystemException e) {
            //6.处理异常情况
            response.ok = 0;
            response.reason = e.getMessage();
            String jsonString = gson.toJson(response);
            resp.getWriter().write(jsonString);
        }
    }

    /**
     * 修改订单状态
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Response response = new Response();
        try {
            //1.检查用户的登录状态
            HttpSession session = req.getSession(false);
            if (session == null) {
                throw new OrderSystemException("您当前尚未登录");
            }
            User user = (User)session.getAttribute("user");
            if (user == null) {
                throw new OrderSystemException("您当前尚未登录");
            }
            //2.判断用户是否是管理员
            if (user.getIsAdmin() == 0) {
                throw new OrderSystemException("您不是管理员");
            }
            //3.读取请求中的字段orderId 和isDone
            String orderIdStr = req.getParameter("orderId");
            String isDoneStr = req.getParameter("isDone");
            if (orderIdStr == null || isDoneStr == null) {
                throw new OrderSystemException("参数有误");
            }
            //4.修改数据库
            OrderDao orderDao = new OrderDao();
            int orderId = Integer.parseInt(orderIdStr);
            int isDone = Integer.parseInt(isDoneStr);
            orderDao.changeState(orderId,isDone);
            //5.返回响应结果
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
