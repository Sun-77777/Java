package exception;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;

public class OrderSystemUtil {
    //需要实现读取body的功能
    //需要先把整个body读取出来，然后才能去解析JSON
    /*public static String readBody(HttpServletRequest request) throws IOException {
        //先去获取到body的长度
        int length = request.getContentLength();
        byte[] buffer = new byte[length];

    }*/
}
