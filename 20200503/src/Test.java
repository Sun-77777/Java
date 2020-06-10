public class Test {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        try {
            System.out.println("before");
            System.out.println(arr[100]);
            System.out.println("after");
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        System.out.println("after try catch");
    }
}
