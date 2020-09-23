package DAY2;

public class B {
    public static void main(String[] args) {
        int a = 1;
        double b = 1;
        System.out.println(a == b);


        for (int i = 0; i < 100; i++) {
            a++;
            b++;
        }
        System.out.println(a == b);
    }
}
