public class ThreadDemo4 {
    static class counter {
        public int count = 0;
        public void increase() {
            count++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        counter c = new counter();
        Thread t = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 50000; i++) {
                    c.increase();
                }
            }
        };
        t.start();;
        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 50000; i++) {
                    c.increase();
                }
            }
        };
        t2.start();
        t.join();
        t2.join();
        System.out.println(c.count);
    }
}
