public class Main2 {
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                dianping();
            }
        };
        t.start();
        System.out.println("dazhong");
    }
    static void dianping() {
        System.out.println("dianping");
    }
}
