public class 猴子吃桃子 {
    public static void main(String[] args) {
        int s = 1;
        int day = 9;
        int sum = 0;
        for (int i = day; i >= 1; i--) {
            sum = 2 * (s + 1);
            s = sum;
        }
        System.out.println(sum);
    }
}
