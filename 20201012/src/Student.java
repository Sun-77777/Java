
class Peoplew {
    public Peoplew() {
        System.out.println(1);
    }
}
public class Student extends Peoplew{
    public Student() {
        System.out.println(2);
    }
    public static void main(String[] args) {
        new People();
        new Student();
    }
}
