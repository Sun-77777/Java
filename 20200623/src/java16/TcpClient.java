package java16;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TcpClient {
    //1.先启动客户端（一定不要绑定端口号）
    //2.进入主循环
    //a) 读取用户输入内容
    //b) 构造一个请求发送给服务器
    //c)读取服务器的响应数据
    //d)把响应数据显示到界面上
    private Socket socket = null;

    public TcpClient(String serverIp,int serverPort) throws IOException {
        socket = new Socket(serverIp,serverPort);
        //new成功以后，就和服务器连接建立成功
    }

    public void start() {
        System.out.println("客户端启动");
        Scanner scanner = new Scanner(System.in);
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))){
            while (true) {
                System.out.print("->");
                String request = scanner.nextLine();
                if ("exit".equals(request)) {
                    break;
                }
                //b.客户端发送请求
                bufferedWriter.write(request + "/n");
                //c.从服务器读取响应
                String response = bufferedReader.readLine();
                //d.把响应数据显示到界面上
                System.out.println(response);
            }
        } catch (IOException e) {

        }
    }

    public static void main(String[] args) throws IOException {
        TcpClient client = new TcpClient("127.0.0.0",9090);
        client.start();
    }
}
