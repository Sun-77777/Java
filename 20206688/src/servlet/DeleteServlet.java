package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Music;
import service.MusicService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        String idStr = req.getParameter("id");
        int id = Integer.parseInt(idStr);

        Map<String,Object> return_map = new HashMap<>();

        MusicService musicService = new MusicService();

        //1.看当前id的音乐是否存在
        Music music = musicService.findMusicById(id);
        if (music == null) {
            return;
        }

        //2.删除
        int delete = musicService.deleteMusicById(id);
        if (delete == 1) {
            System.out.println("数据库中删除成功");

            File file = new File("D:\\Javacodeeee\\Java\\20206688\\web\\" + music.getUrl() + ".mp3");

            if (file.delete()) {
                return_map.put("msg",true);
                System.out.println("服务器删除成功");
            } else {
                return_map.put("msg",false);
                System.out.println("服务器删除失败");
            }
        } else {
            System.out.println("数据库删除失败");
            return_map.put("msg",false);
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(),return_map);

    }
}
