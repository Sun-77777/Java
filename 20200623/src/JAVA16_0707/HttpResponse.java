package JAVA16_0707;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
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

    public void flush() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("version" + " " + status + " " + message);
        headers.put("Content-Length",body.toString().getBytes().length + "");
        for (Map.Entry<String,String> header : headers.entrySet()) {
            bufferedWriter.write(header.getKey() + ": " + header.getValue());
        }
        bufferedWriter.write("\n");
        bufferedWriter.write(body.toString());
        bufferedWriter.flush();
    }



}
