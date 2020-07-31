public class ThreadDemo7 {
    static class Counter {
        public int count = 0;

        synchronized public void increase() {
            count++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 50000; i++) {
                    counter.increase();
                }
            }
        };
        t.start();

        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 50000 ; i++) {
                    counter.increase();
                }
            }
        };
        t2.start();
        t.join();
        t2.join();

        System.out.println(counter.count);
    }
}
