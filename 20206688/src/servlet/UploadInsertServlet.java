package servlet;


import entity.User;
import service.MusicService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


@WebServlet("/uploadsucess")
public class UploadInsertServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");

        String fileName = (String) req.getSession().getAttribute("fileName");
        String[] strings = fileName.split("\\.");
        String title = strings[0];
        String singer = req.getParameter("singer");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String time = sdf.format(new Date());
        String url = "music\\" + title;
        User user = (User) req.getSession().getAttribute("user");
        int user_id = user.getId();

        MusicService musicService = new MusicService();
        int ret = musicService.insertMusic(title,singer,time,url,user_id);
        if (ret != 0) {
            resp.sendRedirect("list.html");
        } else {
            System.out.println("上传数据库失败");
        }


    }
}
