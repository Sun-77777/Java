package JAVA16_0707;

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
    private Map<String,String> headers = new HashMap<>();
    private Map<String,String> parameters = new HashMap<>();
    private Map<String,String> cookies = new HashMap<>();
    private String body;

    public static HttpRequest build(InputStream inputStream) throws IOException {
        HttpRequest request = new HttpRequest();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        //解析首行
        String firstLine = bufferedReader.readLine();
        String[] firstLineTokens = firstLine.split(" ");
        request.method = firstLineTokens[0];
        request.url = firstLineTokens[1];
        request.version = firstLineTokens[2];
        //解析URL
        int pos = request.url.indexOf("?");
        if (pos != -1) {
            String parameter = request.url.substring(pos+1);
            parseKv(parameter,request.parameters);
        }
        //解析header
        String line = "";
        while ((line = bufferedReader.readLine()) != null && line.length() != 0) {
            String[] headerTokens = line.split(": ");
            request.headers.put(headerTokens[0],headerTokens[1]);
        }
        //解析cookie
        String cookie = request.headers.get("Cookie");
        if (cookie != null) {
            parseCookie(cookie,request.cookies);
        }
        //解析body
        if ("POST".equalsIgnoreCase(request.method) || "PUT".equalsIgnoreCase(request.method)) {
            int contentLength = Integer.parseInt(request.headers.get("Content-Length"));
            char[] buffer = new char[contentLength];
            int len = bufferedReader.read(buffer);
            request.body = new String(buffer,0,len);
            parseKv(request.body,request.parameters);
        }
        return request;
    }

    private static void parseCookie(String cookie, Map<String, String> cookies) {
        String[] kv = cookie.split("&");
        for (String res : kv) {
            String[] s = res.split("=");
            cookies.put(s[0],s[1]);
        }
    }

    private static void parseKv(String parameter, Map<String, String> parameters) {
        String[] kv = parameter.split("&");
        for (String res : kv) {
            String[] s = res.split("=");
            parameters.put(s[0],s[1]);
        }
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

    public String  getHeaders(String key) {
        return headers.get(key);
    }

    public String getParameters(String key) {
        return parameters.get(key);
    }

    public String getCookies(String key) {
        return cookies.get(key);
    }

    public String getBody() {
        return body;
    }
}
