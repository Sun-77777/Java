package JAVA_0705;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
    private String method;
    private String url;
    private String version;
    Map<String,String> headers = new HashMap<>();
    Map<String,String> parameters = new HashMap<>();
    private static HttpRequest build(InputStream inputStream) throws IOException {
        //读取请求并解析
        HttpRequest request = new HttpRequest();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        //1.解析首行
        String firstLine = bufferedReader.readLine();
        String[] firstLineTokens = firstLine.split(" ");
        request.method = firstLineTokens[0];
        request.url = firstLineTokens[1];
        request.version = firstLineTokens[2];

        //2.解析URL
        int pos = request.url.indexOf("?");
        if (pos != -1) {
            String parameter = request.url.substring(pos+1);
            String[] parameterTokens = parameter.split("&");
            for (String ss : parameterTokens) {
                String[] s = ss.split("=");
                request.parameters.put(s[0],s[1]);
            }
        }
        //3.解析header
        String line = "";
        while ((line = bufferedReader.readLine()) != null && line.length() != 0) {
            String[] headersToken = line.split(": ");
            request.headers.put(headersToken[0],headersToken[1]);
        }

        return request;
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public String getVersion() {
        return version;
    }

    public String getHeaders(String key) {
        return headers.get(key);
    }

    public String getParameters(String key) {
        return parameters.get(key);
    }
}
