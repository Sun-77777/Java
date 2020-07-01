package Java_0629;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TcpClient {
    private Socket socket = null;

    public TcpClient(String serverIp,int serverPort) throws IOException {
        socket = new Socket(serverIp,serverPort);
        //new 以后，就与服务器成功建立连接
    }

    public void start() {
        System.out.println("客户端启动");
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))){

            while (true) {
                System.out.print("->");
                //1.读取用户输入内容
                Scanner scanner = new Scanner(System.in);
                String request = scanner.nextLine();

                //2.构造请求并发送
                bufferedWriter.write(request+ "\n");
                bufferedWriter.flush();
                //3.读取响应数据
                String response = bufferedReader.readLine();

                //4.把响应写回到界面
                System.out.println(response);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        TcpClient client = new TcpClient("127.0.0.1",9090);
        client.start();
    }
}
