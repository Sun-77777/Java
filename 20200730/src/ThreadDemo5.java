public class ThreadDemo5 {
    static class Test {
        public void method() {
            synchronized (this) {
                System.out.println("hehe");
            }
        }
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.method();
    }
}
