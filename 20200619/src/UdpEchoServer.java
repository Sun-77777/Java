import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoServer {
    //1.
    //2.
    //a.读取数据并解析
    //b.
    //c.
    private DatagramSocket socket = null;
    public UdpEchoServer(int port) throws SocketException {
        //new这个Socket对象的时候，就会让当前的socket对象和一个IP地址以及一个端口号关联起来（绑定端口
        //在构造socket的时候如果没写IP，默认是0.0.0.0（特殊IP）会关联到这个主机的所有网卡的IP（一台主机可能有多个网卡）
        socket = new DatagramSocket(port);
    }
    public void start() throws IOException {
        System.out.println("服务器启动");
        while (true) {
            //a.
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096],4096);
            socket.receive(requestPacket);
            String request = new String(requestPacket.getData(),0,requestPacket.getLength()).trim();
            //b.
            String response = process(request);
            //c.
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),response.getBytes().length,requestPacket.getSocketAddress());
            socket.send(responsePacket);

            System.out.printf("[%s:%d] req: %s; resp:%s\n",requestPacket.getAddress().toString(),requestPacket.getPort(),request,response);
        }
    }

    public String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer server = new UdpEchoServer(9090);
        server.start();
    }
}
