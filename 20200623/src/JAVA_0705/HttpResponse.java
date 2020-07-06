package JAVA_0705;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

//表示一个http响应，负责构造
//序列化操作
public class HttpResponse {
    private String version = "HTTP/1.1";
    private int status;
    private String message;
    private Map<String,String> headers = new HashMap<>();
    private StringBuffer body = new StringBuffer();//方便一会进行拼接
    //当代吗需要把响应写回给客户端的时候，就往这个outputStream 中写就好了
    private OutputStream outputStream;

    //工厂方法构造对象
    public static HttpResponse build(OutputStream outputStream) {
        HttpResponse response = new HttpResponse();
        response.outputStream = outputStream;
        //除了outputStream其他的属性的内容，暂时都无法确定，要根据代码的具体业务逻辑来确定。（服务器的“根据请求并计算响应”阶段来进行设置的）
        return response;
    }

    //写入outputStream，之前在内存中
    //以上的设置属性的操作都是在内存中倒腾，还需要一个专门的方法，把这些属性按照HTTP协议都写到socket中。
    public void flush() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write(version + " " + status + " " + message + "\n");
        headers.put("Content-Length",body.toString().getBytes().length + "");
        for (Map.Entry<String,String> entry : headers.entrySet()) {
            bufferedWriter.write(entry.getKey() + ": " + entry.getValue() + "\n");
        }
        bufferedWriter.write("\n");
        bufferedWriter.write(body.toString());
        bufferedWriter.flush();
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setHeaders(String key,String value) {
        headers.put(key,value);
    }

    public void setBody(String content) {
        body.append(content);
    }
}
