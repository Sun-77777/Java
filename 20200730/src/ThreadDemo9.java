public class ThreadDemo9 {
    static class Singleton {
        private Singleton() { }

        private static Singleton instance = new Singleton();
        public static Singleton getInstance() {
            return instance;
        }
    }

    public static void main(String[] args) {
        Singleton s = Singleton.getInstance();
    }
}
