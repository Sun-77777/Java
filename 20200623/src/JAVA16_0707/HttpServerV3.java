package JAVA16_0707;

import Java16_0627.Http;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServerV3 {
    private ServerSocket serverSocket = null;

    public HttpServerV3(int port) throws IOException {
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
                    try {
                        process(clientSocket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private void process(Socket clientSocket) throws IOException {
        HttpRequest request = HttpRequest.build(clientSocket.getInputStream());
        HttpResponse response = HttpResponse.build(clientSocket.getOutputStream());
        //根据请求计算响应

        response.flush();
    }

    public static void main(String[] args) {


    }
}
