package servlet;

import entity.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet("/upload")
public class UploadMusicServlet extends HttpServlet {

    //private final String PATH = "D:\\Javacodeeee\\Java\\20206688\\web\\music";
    private final String PATH = "/root/java16/apache-tomcat-8.5.57/webapps/onlineMusic/music";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");

        User user = (User) req.getSession().getAttribute("user");

        if (user == null) {
            System.out.println("请登录后在上传音乐");
            resp.getWriter().write("<h2>请登录后在上传音乐" + "</h2>");
        } else {
            //一个接口 两个类
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            List<FileItem> fileItems = null;

            try {
                fileItems = upload.parseRequest(req);
            } catch (FileUploadException e) {
                e.printStackTrace();
            }

            System.out.println("fileItems:" + fileItems);
            FileItem fileItem = fileItems.get(0);
            System.out.println("fileItem:" + fileItem);

            String fileName = fileItem.getName();
            req.getSession().setAttribute("fileName",fileName);

            //怎么把音乐放到music目录下面
            try {
                fileItem.write(new File(PATH,fileName));
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }

            //2.已经上传到服务器，接下来上传到数据库
            resp.sendRedirect("uploadsucess.html");
        }

    }
}
