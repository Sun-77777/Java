public class ThreadDemo1 {
    static class BlockingQueue {
        private int[] array = new int[1000];
        private int head = 0;
        private int tail = 0;
        private int size = 0;

        //阻塞队列的入队列
        public void put(int value) throws InterruptedException {
            //可以不是对this加锁，
            synchronized (this) {
                if (size == array.length) {
                    wait();
                }
                array[tail] = value;
                tail++;
                if (tail == array.length) {
                    tail = 0;
                }
                size++;

                notify();
            }

        }
        //出队列
        public int take() throws InterruptedException {
            int ret = -1;
            synchronized (this) {
                if (size == 0) {
                    wait();
                }
                ret = array[head];
                head++;
                if (head == array.length) {
                    head = 0;
                }
                size--;

                notify();
            }
            return ret;
        }

        public static void main(String[] args) {
            BlockingQueue blockingQueue = new BlockingQueue();
            Thread producer = new Thread() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        try {
                            blockingQueue.put(i);
                            System.out.println("生产元素：" + i);
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            producer.start();
            Thread customer = new Thread() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            int ret = blockingQueue.take();
                            System.out.println("消费元素: " + ret);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            customer.start();
        }
    }
}
