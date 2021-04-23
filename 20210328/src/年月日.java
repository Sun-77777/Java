import java.util.Scanner;

public class 年月日 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int day = scanner.nextInt();

        int[] arr = {31,28,31,30,31,30,31,31,30,31,30,31};
        int sum = 0;
        for (int i = 0; i < month-1; i++) {
            sum += arr[i];
        }
        sum = sum + day;
        if (year % 4 == 0 && year % 100 == 0 || year % 400 == 0) {
            sum += 1;
        }
        System.out.println(sum);
    }
}
