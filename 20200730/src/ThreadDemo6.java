import java.util.Scanner;

public class ThreadDemo6 {
    static class Counter {
        public volatile int flag = 0;
        //volatile 保持内存可见性
    }
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread t = new Thread() {
            @Override
            public void run() {
                while (counter.flag == 0) {

                }
                System.out.println("循环结束");
            }
        };
        t.start();

        Thread t2 = new Thread() {
            @Override
            public void run() {
                Scanner scanner = new Scanner(System.in);
                System.out.println("请输入一个整数");
                counter.flag = scanner.nextInt();
            }
        };
        t2.start();
    }
}
