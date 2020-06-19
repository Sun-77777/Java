public class B {
    public static void main(String[] args) {
        int i = 5;
        int s = i++; //5
        s = s + ++i; //7
        s = s + i--; //7
        s = s + --i; //5
        System.out.println(s); //24
    }
}
