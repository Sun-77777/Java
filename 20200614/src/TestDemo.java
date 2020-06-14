public class TestDemo {
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("hello，我是一个线程");
            while (true) {

            }
        }
    }
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
        while (true) {

        }
    }
}
