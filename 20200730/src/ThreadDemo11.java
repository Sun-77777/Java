public class ThreadDemo11 {
    static class Singleton {
        private Singleton() { }

        private volatile static Singleton instance = null;

        private static Singleton getInstance() {
            if (instance == null) {
                synchronized (Singleton.class) {
                    if (instance == null) {
                        instance = new Singleton();
                    }
                }
            }
            return instance;
        }
    }
}
