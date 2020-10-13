import java.util.LinkedList;

public class C {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add("A");
        list.add(2,"B");
        String s = (String)list.get(1);
        System.out.println(s);
    }
}
