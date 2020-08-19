public class MyStack {
    private int[] array = new int[100];
    private int size = 0;
    public void push(int val) {
        array[size] = val;
        size++;
    }
    public int pop() {
        int ret = array[size-1];
        size--;
        return ret;
    }

    public int peek() {
        return array[size-1];
    }
}
