public class Test1 {
    private int count;

    public static void main(String[] args) {
        Test1 test1 = new Test1(88);
        System.out.println(test1.count);
    }
    Test1(int a) {
        count = a;
    }
}
