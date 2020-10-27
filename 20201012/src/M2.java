class People {
    String name;
    public People() {
        System.out.print(1);
    }
    public People(String name) {
        System.out.println(2);
        this.name = name;
    }
 }
public class M2 extends People {
    People father;
    public M2(String name) {
        System.out.println(3);
        this.name = name;
        father = new People(name + "F");
    }
    public M2() {
        System.out.println(4);
    }
    public static void main(String[] args) {
        new M2("Mike");
    }
}
