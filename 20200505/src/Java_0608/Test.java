package Java_0608;

public class Test {
    public int aMethod() {
        int i = 0;
        i++;
        return i;
    }
    public static void main(String[] args) {
        Test test = new Test();
        test.aMethod();
        int j = test.aMethod();
        System.out.println(j);
    }
}
