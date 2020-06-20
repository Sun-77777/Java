public class TestDemo {
    public String name = "abc";

    public static void main(String[] args) {
        TestDemo testDemo1 = new TestDemo();
        TestDemo testDemo2 = new TestDemo();
        System.out.println(testDemo1.equals(testDemo2) + "," + testDemo1.name.equals(testDemo2.name));
    }
}
