

class Person {
    String name = "No name";
    public Person(String nm) {
        name = nm;
    }

    public Person() {

    }
}
class Employee extends Person {
    String empId = "0000";
    public Employee(String id) {
        super();
        empId = id;
    }
}
public class Test {
    public static void main(String[] args) {
        Employee e = new Employee("123");
        System.out.println(e.empId);
    }
}
