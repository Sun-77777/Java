class A {
    public A(String s) {

    }
}
public class Test {
    public static void main(String[] args) {
        A classa = new A("heh");
        A classb = new A("heh");
        System.out.println(classa == classb); //false
    }
}
