package JAVA16_0707;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class HttpResponse {
    private String version = "HTTP/1.1";
    private int status;
    private String message;
    private OutputStream outputStream;
    private Map<String,String> headers = new HashMap<>();
    private StringBuffer body = new StringBuffer();

    public static HttpResponse build (OutputStream outputStream) {
        HttpResponse response = new HttpResponse();
        response.outputStream = outputStream;
        return response;
    }



}
