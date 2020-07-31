import java.util.Scanner;

public class ThreadDemo8 {
    public static void main(String[] args) {
        Object locker = new Object();

        Thread t = new Thread() {
            @Override
            public void run() {
                synchronized (locker) {
                    while (true) {
                        try {
                            System.out.println("等待前");
                            locker.wait();
                            System.out.println("等待后");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        t.start();

        Thread tt = new Thread() {
            @Override
            public void run() {
                System.out.println("输入任意一个整数，继续执行notify");
                Scanner scanner = new Scanner(System.in);
                int n = scanner.nextInt();
                //synchronized (locker) {
                    System.out.println("notify 开始");
                    locker.notify();
                    System.out.println("notify 结束");
                //}
            }
        };
        tt.start();

    }
}
