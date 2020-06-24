package Java16_0624;

public class MathCal {
    public static void main(String[] args) {
        Integer a = 22;
        int b = 22;
        Integer c = Integer.valueOf(22);
        Integer d = new Integer(22);
        System.out.println(a == b);//true
        System.out.println(a == c);//true
        System.out.println(c == d);//false
        System.out.println(b == d);//true
        System.out.println(a == d);//false
        System.out.println(b == c);//true
    }
}
