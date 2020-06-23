package java16;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpThreadEchoServer {
    private ServerSocket serverSocket = null;

    public TcpThreadEchoServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }
    
    public void start() throws IOException {
        System.out.println("服务器启动");
        while (true) {
            Socket clientSocket = serverSocket.accept();
            Thread t = new Thread() {
                @Override
                public void run() {
                    processConnection(clientSocket);
                }
            };
            t.start();
        }
    }

    private void processConnection(Socket clientSocket) {
    }
}
