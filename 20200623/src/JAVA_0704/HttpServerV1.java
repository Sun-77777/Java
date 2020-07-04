package JAVA_0704;

import Java16_0627.Http;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServerV1 {
    private ServerSocket serverSocket = null;

    public HttpServerV1(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            ExecutorService executorService = Executors.newCachedThreadPool();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    connectProcess(clientSocket);
                }
            });
        }
    }
    private void connectProcess(Socket clientSocket) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))){
            //1.接收请求并解析
            //a.首行
            String firstLine = bufferedReader.readLine();
            String[] firstLineTokens = firstLine.split(" ");
            String method = firstLineTokens[0];
            String url = firstLineTokens[1];
            String version = firstLineTokens[2];
            //b.协议头
            Map<String,String> map = new HashMap<>();
            String line = "";
            while ((line = bufferedReader.readLine()) != null && line.length() != 0) {
                String[] headerTokens = line.split(": ");
                map.put(headerTokens[0],headerTokens[1]);
            }
            //c.body

            System.out.printf("%s %s %s\n",method,url,version);
            for (Map.Entry<String,String> entry : map.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            System.out.println();
            //2.根据请求计算响应
            String resp = "";
            if (url.equals("/OK")) {
                resp = "<h1>hello</h1>";
                bufferedWriter.write(version + " 200 OK\n");
            } else if (url.equals("/seeother")) {
                bufferedWriter.write(version + " 303 See Other\n");
                bufferedWriter.write("Location: http://www.sogou.com\n");
                resp = "";
            } else if (url.equals("/NotFound")) {
                resp = "<h1>not found</h1>";
                bufferedWriter.write(version + " 404 Not Found\n");
            } else {
                resp = "<h1>default</h1>";
                bufferedWriter.write(version + " 200 OK\n");
            }
            //3.把响应返回给客户端
            bufferedWriter.write("Context-Type: text/html\n");
            bufferedWriter.write("Content-Length: " + resp.getBytes().length + "\n");
            bufferedWriter.write("\n");
            bufferedWriter.write(resp);
            bufferedWriter.flush();//可有可无

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        HttpServerV1 server = new HttpServerV1(9090);
        server.start();
    }
}
