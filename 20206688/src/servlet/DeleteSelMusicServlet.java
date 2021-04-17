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

@WebServlet("/deleteSelMusicServlet")
public class DeleteSelMusicServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");

        String[] ids = req.getParameterValues("id[]");
        MusicService musicService = new MusicService();
        int count = 0;
        Map<String,Object> return_map = new HashMap<>();

        for (int i = 0; i < ids.length; i++) {
            int id = Integer.parseInt(ids[i]);

            Music music = musicService.findMusicById(id);
            int delete = musicService.deleteMusicById(id);
            if (delete == 1) {
                File file = new File("D:\\Javacodeeee\\Java\\20206688\\web\\" + music.getUrl() + ".mp3");
                //File file = new File("/root/java16/apache-tomcat-8.5.57/webapps/onlineMusic/" + music.getUrl() + ".mp3");

                if (file.delete()) {
                    count += delete;
                } else {
                    return_map.put("msg",false);
                    System.out.println("服务器删除失败");
                }
            } else {
                return_map.put("msg",false);
                System.out.println("数据库删除失败");
            }
        }

        if (count == ids.length) {
            return_map.put("msg",true);
        } else {
            return_map.put("msg",false);
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(),return_map);
    }
}
