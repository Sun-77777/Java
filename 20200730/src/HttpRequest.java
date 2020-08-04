import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
    private String method;
    private String url;
    private String version;

    private Map<String,String> headers = new HashMap<>();
    private Map<String,String> parameters = new HashMap<>();

    public static HttpRequest build(InputStream inputStream) throws IOException {
        HttpRequest request = new HttpRequest();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String firstLine = bufferedReader.readLine();
        String[] firstLineTokens = firstLine.split(" ");
        request.method = firstLineTokens[0];
        request.url = firstLineTokens[1];
        request.version = firstLineTokens[2];

        int pos = request.url.indexOf("?");
        if (pos != -1) {
            String parameters = request.url.substring(pos + 1);
            parseKV(parameters,request.parameters);
        }

        String line = "";
        while ((line = bufferedReader.readLine()) != null && line.length() != 0) {
            String[] headerTokens = line.split(": ");
            request.headers.put(headerTokens[0],headerTokens[1]);
        }

        return request;
    }

    private static void parseKV(String parameter, Map<String, String> parameters) {
        String[] kvTokens = parameter.split("&");
        for (String kv : kvTokens) {
            String[] ret = kv.split("=");
            parameters.put(ret[0],ret[1]);
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

    public String getHeaders(String key) {
        return headers.get(key);
    }

    public String getParameters(String key) {
        return parameters.get(key);
    }
}
