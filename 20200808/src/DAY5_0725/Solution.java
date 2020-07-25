package DAY5_0725;

import java.util.Stack;

public class Solution {
    public Stack<Integer> data_stack = new Stack<>();
    public Stack<Integer> min_stack = new Stack<>();

    public void push(int node) {
        if (data_stack.isEmpty()) {
            data_stack.push(node);
            min_stack.push(node);
        } else {
            if (data_stack.peek() > node) {
                min_stack.push(node);
            } else {
                min_stack.push(min_stack.peek());
            }
            data_stack.push(node);
        }
    }

    public void pop() {
        data_stack.pop();
        min_stack.pop();
    }

    public int top() {
        return data_stack.peek();
    }

    public int min() {
        return min_stack.peek();
    }
}
