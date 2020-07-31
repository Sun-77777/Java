public class ThreadDemo1 {
    public static class MyThread extends Thread {


    }
    public static void main(String[] args) {
        Thread t = new Thread(new MyThread());


    }
}
