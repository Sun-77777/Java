import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] num = new int[n];
        int sum = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(scan.next());
            sum = sum+num[i];
            if (sum == 40) {
                end = i;
            }
        }

    }
}
