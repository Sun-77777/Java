import java.util.concurrent.PriorityBlockingQueue;

public class ThreadDemo15 {
    static class Task implements Comparable<Task>{
        private Runnable command;
        private long time;

        public Task(Runnable command, long after) {
            this.command = command;
            this.time = System.currentTimeMillis() + after;
        }

        public void run() {
            command.run();
        }

        @Override
        public int compareTo(Task o) {
            return (int) (this.time - o.time);
        }
    }
    static class Worker extends Thread {
        private PriorityBlockingQueue<Task> queue = null;
        private Object mailBox = null;
        public Worker(PriorityBlockingQueue<Task> queue,Object mailBox) {
            this.queue = queue;
            this.mailBox = mailBox;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Task task = queue.take();
                    long curTime = System.currentTimeMillis();
                    if (task.time > curTime) {
                        queue.put(task);
                        synchronized (mailBox) {
                            mailBox.wait(task.time - curTime);
                        }
                    } else {
                        task.run();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }

            }
        }
    }
    static class Timer {
        private PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<>();
        private Object mailBox = new Object();
        public Timer() {
            Worker worker = new Worker(queue,mailBox);
            worker.start();
        }
        public void schedule(Runnable command,long after) {
            Task task = new Task(command,after);
            queue.put(task);

            synchronized (mailBox) {
                mailBox.notify();
            }
        }

    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("haha");
            }
        },2000);
    }
}
