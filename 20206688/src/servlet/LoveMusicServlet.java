package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.User;
import service.MusicService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/loveMusicServlet")
public class LoveMusicServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");

        User user = (User) req.getSession().getAttribute("user");
        int user_id = user.getId();
        String id = req.getParameter("id");
        int music_id = Integer.parseInt(id);

        Map<String,Object> return_map = new HashMap<>();

        MusicService musicService = new MusicService();
        boolean boo = musicService.insertLoveMusic(user_id,music_id);
        if (boo) {
            return_map.put("msg",true);
        } else {
            return_map.put("msg",false);
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(),return_map);

    }
}
