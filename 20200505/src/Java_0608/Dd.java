package Java_0608;

class Base {
    public Base(String s) {
        System.out.print("B");
    }


    Base() {
    }
}
public class Dd extends Base{
    public Dd(String s) {

        System.out.print("D");
    }
    public static void main(String[] args) {
        new Dd("C");
    }
}
