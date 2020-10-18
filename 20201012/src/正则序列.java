import java.util.Arrays;
import java.util.Scanner;

public class 正则序列 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nstr = scanner.nextLine();
        int n = Integer.parseInt(nstr);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(scanner.next());
        }
        Arrays.sort(arr);
        int[] res = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            res[i] = i + 1;
            if (res[i] < arr[i]) {
                count += (arr[i] - res[i]);
            } else  {
                count += (res[i] - arr[i]);
            }
        }
        System.out.println(count);

    }
}
