package Java_0608;

public class ThreadDemo {
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("我是一个线程");
        }
    }
    public static void main(String[] args) {
        Thread t = new MyThread();
        t.start();
    }
}
