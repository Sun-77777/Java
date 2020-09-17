package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Music;
import entity.User;
import service.MusicService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/findLoveMusic")
public class FindLoveMusicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");

        MusicService musicService = new MusicService();

        User user = (User) req.getSession().getAttribute("user");
        int user_id = user.getId();

        List<Music> musicList = new ArrayList<>();

        String loveMusicName = req.getParameter("loveMusicName");
        if (loveMusicName == null) {
            musicList = musicService.findLoveMusic(user_id);
        } else {
            musicList = musicService.ifLoveMusic(loveMusicName,user_id);
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(),musicList);
    }
}
