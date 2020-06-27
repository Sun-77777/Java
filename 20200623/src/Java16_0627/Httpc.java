package Java16_0627;

import java.io.IOException;
import java.net.ServerSocket;

public class Httpc {
    private ServerSocket serverSocket = null;

    public Httpc(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() {
        System.out.printf("");

    }
}
