public class ThreadDemo {
    //懒汉模式
    static class Singleton {
        private Singleton() {}
        private static Singleton instance = null;

        public static Singleton getInstance() {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
            return instance;
        }
    }
}
