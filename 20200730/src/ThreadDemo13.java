import java.util.concurrent.PriorityBlockingQueue;

public class ThreadDemo13 {
    static class Task implements Comparable<Task> {
        //Runnable中有一个run方法，就可以借助这个run方法来描述要执行的具体的任务是啥
        private Runnable command;
        //
        private long time;

        public Task(Runnable command,long after) {
            this.command = command;
            this.time = System.currentTimeMillis() + after;
        }

        //执行任务的具体逻辑
        public void run() {
            command.run();
        }

        @Override
        public int compareTo(Task o) {
            //时间小的优先级高
            return (int) (this.time - o.time);
        }
    }

    static class Worker extends Thread{
        private PriorityBlockingQueue<Task> queue = null;
        private Object mailBox = null;

        public Worker(PriorityBlockingQueue<Task> queue,Object mailBox) {
            this.queue = queue;
            this.mailBox = mailBox;
        }

        @Override
        public void run() {
            //实现具体的线程执行的内容
            while (true) {
                try {
                    //1.先取出队首元素，检查时间是否到了
                    Task task = queue.take();
                    long curTime = System.currentTimeMillis();
                    if (task.time > curTime) {
                        //时间还没到，就把任务再放回队列中
                        queue.put(task);

                        //会出现忙等
                        //大大降低了循环的执行次数
                        synchronized (mailBox) {
                            mailBox.wait(task.time-curTime);
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
        //为了避免忙等 使用wait
        private Object mailBox = new Object();
        //定时器的基本构成，有三个部分
        //1.用一个类来描述任务
        //2.用一个阻塞优先队列来组织若干个任务，
        //让队首元素就是时间最早的任务
        private PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<>();
        //3.用一个线程来循环扫描当前的阻塞队列的队首元素，如果时间到，就执行执行的任务
        public Timer() {
            //创建线程
            Worker worker = new Worker(queue,mailBox);
            worker.start();
        }
        //4.还需要提供一个方法，让调用这能把任务给"安排"进来
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
                timer.schedule(this,2000);
            }
        },2000);
    }
}
