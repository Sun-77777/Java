package java_0713;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
@MultipartConfig
public class ServletDemo10 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //收到图片，直接把图片保存到某个路径中
        String basePath = "d:/java16/images/";
        Part part = req.getPart("image");
        String path = basePath + part.getSubmittedFileName();
        part.write(path);

        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().write("图片上传成功");

    }
}
