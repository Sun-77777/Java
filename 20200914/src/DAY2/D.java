package DAY2;

class Test {
    public void add(Byte b) {
        b = b++;
    }
    public void test() {
        Byte a = 127;
        Byte b = 127;
        add(++a);
        System.out.println(a+"");
        add(b);
        System.out.println(b+"");
    }
}
public class D {
    public static void main(String[] args) {
        Test test = new Test();
        test.test();
    }
}
