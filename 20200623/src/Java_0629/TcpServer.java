package Java_0629;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    private ServerSocket serverSocket= null;

    public TcpServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.printf("服务器启动");
        //先从内核中获取到一个TCP 连接
        Socket clientSocket = serverSocket.accept();
    }
}
