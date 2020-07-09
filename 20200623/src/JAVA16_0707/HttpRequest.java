package JAVA16_0707;

import java.io.InputStream;
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

    public static HttpRequest build(InputStream inputStream) {
        HttpRequest request = new HttpRequest();

        return request;
    }
    
}
