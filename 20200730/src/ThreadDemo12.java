public class ThreadDemo12 {
    static class BlockingQueue {
        private int[] array = new int[1000];
        private int head = 0;
        private int tail = 0;
        private volatile int size = 0;

        //入队列
        public  void put(int value) throws InterruptedException {
            synchronized (this) {
                while (size == array.length) {
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
        public  int take() throws InterruptedException {
            synchronized (this) {
                while (size == 0) {
                    wait();
                }
                int ret = -1;
                ret = array[head];
                head++;
                if (head == array.length) {
                    head = 0;
                }
                size--;
                notify();
                return ret;
            }
        }
    }

    public static void main(String[] args) {
        BlockingQueue blockingQueue = new BlockingQueue();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1000 ; i++) {
                    try {
                        blockingQueue.put(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }

}
