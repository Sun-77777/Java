import java.util.Scanner;
public class Main3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String ret = getString(n);
        System.out.println(ret);
    }
    public static String getString(int n) {
        int[] num = new int[n];
        if (n % 2 == 0) {
            int c = 0;
            for (int i = n/2; i >= 0; i--) {
                num[i] = n * n + 1 - c;
                c = c + 2;
            }
            int a = num[n/2];
            for (int i = n/2 + 1; i < n; i++) {
                num[i] = num[i-1] + 2;
            }
        } else {
            int c = 0;
            for (int i = n/2; i >= 0; i--) {
                num[i] = n * n - c;
                c = c + 2;
            }
            for (int i = n / 2 + 1; i < n; i++) {
                num[i] = num[i-1] + 2;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n-1; i++) {
            String s = String.valueOf(num[i]);
            sb.append(s);
            sb.append("+");
        }
        sb.append(String.valueOf(num[n-1]));
        return sb.toString();
    }
}
