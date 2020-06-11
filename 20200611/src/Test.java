public class Test {
    //饿汉模式
    //先创建一个表示单例的类
    //Singleton
    static class Singleton {
        //把构造方法变成私有，此时在该类外部就无法new在这个类的实例了。
        private Singleton() { }
        private static Singleton instance = new Singleton();
        public static Singleton getInstance() {
            return instance;
        }
    }

    public static void main(String[] args) {

    }
}
