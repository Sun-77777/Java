package java16;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    private ServerSocket serverSocket = null;

    public TcpServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        while (true) {
            //1.
            Socket clientSocket = serverSocket.accept();
            processConnection(clientSocket);
        }
    }

    private void processConnection(Socket clientSocket) {
        System.out.printf("[%s；%d] 客户端上线\n",clientSocket.getInetAddress().toString(),clientSocket.getPort());

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))){

            //长连接 交互N次，再断开
            while (true) {
                //1.读取请求并解析(按行发送)
                String request = bufferedReader.readLine();
                //2.根据请求计算响应
                String response = process(request);
                //3.把响应返回给客户端

                bufferedWriter.write(response + "\n");

                System.out.printf("[%s:%d] req : %s resp : % s\n",clientSocket.getInetAddress(),clientSocket.getPort(),request,response);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.printf("[%s；%d] 客户端上线\n",clientSocket.getInetAddress().toString(),clientSocket.getPort());
        }
    }

    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpServer server = new TcpServer(9090);
        server.start();
    }
}
