package java16;

import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoClient {
    private DatagramSocket socket = null;
    private String serverIp = null;
    private String serverPort = null;

    public UdpEchoClient(String serverIp,String serverPort) throws SocketException {
        this.serverIp = serverIp;
        this.serverPort = serverPort;
        socket = new DatagramSocket();
    }

    public static void main(String[] args) {

    }

}
