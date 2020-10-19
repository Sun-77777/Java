import java.util.Arrays;
import java.util.Scanner;

public class T {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String tStr = scanner.nextLine();
        int T = Integer.parseInt(tStr);
        while (T > 0) {
            String nStr = scanner.nextLine();
            int n = Integer.parseInt(nStr);
            String str = scanner.nextLine();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str.substring(i,i+1));
            }
            String s = scanner.nextLine();
            int people = Integer.parseInt(s);
            String ss = scanner.nextLine();
            char[] num = ss.toCharArray();
            int[] ret = new int[people];
            for (int i = 0; i < people; i++) {
                for (int j = 0; j < n; j++) {
                    if (num[i] == 'M') {
                        if (arr[j] == 1) {
                            ret[i] = j + 1;
                            arr[j] = 2;
                            i++;
                            j = -1;
                        }
                    } else {
                        if (arr[j] == 0) {
                            ret[i] = j + 1;
                            arr[j] = 1;
                            j = -1;
                            i++;
                        }
                        if (j == n - 1) {
                            j = 0;
                            if (arr[j] == 1) {
                                ret[i] = j + 1;
                                arr[j] = 2;
                                j = -1;
                                i++;
                            }
                        }
                    }
                }
            }
            T--;
            for (int i = 0; i < ret.length; i++) {
                System.out.println(ret[i]);
            }
        }

    }
}
