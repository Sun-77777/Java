package Java_0629;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    private ServerSocket serverSocket= null;

    public TcpServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.printf("服务器启动");
        
        while (true) {
            //先从内核中获取到一个TCP 连接
            Socket clientSocket = serverSocket.accept();
            
            //处理这个连接
            processConnection(clientSocket);
        }

    }

    private void processConnection(Socket clientSocket) throws IOException {
        System.out.printf("[%s %d] 客户端上线\n",clientSocket.getInetAddress().toString(),clientSocket.getPort());
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))){
            while (true) {
                //1.读取请求并解析
                String request = bufferedReader.readLine();
                //2.根据请求计算响应
                String response = process(request);
                //3.把响应返回给客户端
                bufferedWriter.write(response + "\n");

                System.out.printf("[%s:%d] req: %s resp : %s",clientSocket.getInetAddress().toString(),clientSocket.getPort());

            }
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.printf("[%s : %d] 客户端下线\n",clientSocket.getInetAddress().toString(),clientSocket.getPort());
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
