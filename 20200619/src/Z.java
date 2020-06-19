class X {
    Y y = new Y();
    public X() {
        System.out.print("x");
    }
}
class Y {
    public Y() {
        System.out.print("y");
    }
}
public class Z extends X{
    Y y = new Y();
    public Z() {
        System.out.print("z");
    }
    public static void main(String[] args) {
        new Z();

    }
}
