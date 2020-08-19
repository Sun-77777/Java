import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        int ret = stack.pop();
        System.out.println(ret);
        ret = stack.pop();
        System.out.println(ret);
        ret = stack.pop();
        System.out.println(ret);
        ret = stack.pop();
        System.out.println(ret);
        ret = stack.pop();
        System.out.println(ret);
    }
}
