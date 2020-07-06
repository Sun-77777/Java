package JAVA_0705;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServerV2 {
    private ServerSocket serverSocket = null;

    public HttpServerV2(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        ExecutorService executorService = Executors.newCachedThreadPool();

        while (true) {
            Socket clientSocket = serverSocket.accept();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    process(clientSocket);
                }
            });
        }
    }

    private void process(Socket clientSocket) {
        try {
            //1.读取并解析请求
            HttpRequest request = HttpRequest.build(clientSocket.getInputStream());
            System.out.println("request:" + request);
            HttpResponse response = HttpResponse.build(clientSocket.getOutputStream());
            response.setHeaders("Content-Type","text/html");
            //2.根据请求计算响应
            if (request.getUrl().startsWith("/hello")) {
                response.setStatus(200);
                response.setMessage("OK");
                response.setBody("<h1>hello</h1>");
            } else if (request.getUrl().startsWith("/calc")) {
                String aStr = request.getParameters("a");
                String bStr = request.getParameters("b");
                String result = aStr+bStr;
                response.setStatus(200);
                response.setMessage("OK");
                response.setBody("<h1>" + result + "<h1>");
            }else {
                response.setStatus(200);
                response.setMessage("OK");
                response.setBody("<h1>default</h1>");
            }

            //3.把响应写回到客户端
            response.flush();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        } finally {
            try {
                //这个操作会同时关闭getInputStream 和getOutputStream对象
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        HttpServerV2 server = new HttpServerV2(9090);
        server.start();
    }
}
