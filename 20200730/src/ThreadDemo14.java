import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

public class ThreadDemo14 {
    static class Task implements Comparable<Task> {
        //Runnable 中有一个run方法，借助这个run方法来描述要执行的具体任务
        private Runnable command;
        //time 表示啥时候执行command
        private long time;

        public Task(Runnable command, long after) {
            this.command = command;
            this.time = System.currentTimeMillis() + after;
        }

        //执行任务的具体逻辑
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
            //实现具体线程执行的内容
            while (true) {
                //1.取出队首元素，检查时间是否到了
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
        private Object mailBox = new Object();
        //1.用一个类Task来描述任务
        //2.优先阻塞队列（用数据结构来组织）
        // 优先队列需要知道对象之间的大小关系，才能把优先级排列出来（才能保证队首元素是优先级最高的）
        private PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<>();
        //3.扫描线程
        public Timer() {
            Worker worker = new Worker(queue,mailBox);
            worker.start();
        }

        //4.还需要提供一个方法，让调用者把任务安排进去
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
                System.out.println("hehe");
            }
        },5000);
    }
}
