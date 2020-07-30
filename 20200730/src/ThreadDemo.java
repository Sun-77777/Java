import java.util.Scanner;

public class ThreadDemo {
    public static void main(String[] args) {
        Object locker = new Object();
        Thread t = new Thread() {
            @Override
            public void run() {
                Scanner scanner = new Scanner(System.in);
                synchronized (locker) {
                    System.out.println("亲输入一个整数");
                    int num = scanner.nextInt();
                    System.out.println("num=" + num);
                }
            }
        };
        t.start();

        Thread t2 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    synchronized (locker) {
                        System.out.println("线程2获取到锁了");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        t2.start();
    }
}
