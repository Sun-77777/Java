public class TestThread {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("lambda");
        });
        t.start();
    }
}
        /*Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello,Runnable匿名类线程");
            }
        };
        Thread t = new Thread(runnable);
        t.start();*/
    