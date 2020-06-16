import java.util.Scanner;
import java.lang.StringBuffer;
public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] strs = str.split(" ");
        int n = Integer.parseInt(strs[0]);
        int d = (n+1)/2;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append(strs[1]);
        }
        StringBuffer sb1 = new StringBuffer();
        for (int i = 0; i < n; i++) {
            if (i == 0 || i == n-1) {
                sb1.append(strs[1]);
            } else {
                sb1.append(" ");
            }
        }

        for (int i = 0; i < d; i++) {
            if (i == 0 || i == d-1) {
                System.out.println(sb.toString());
            } else {
                System.out.println(sb1.toString());
            }
        }
    }
}
