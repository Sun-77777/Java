package DAY45;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String A = scan.next();
            String B = scan.next();
            StringBuffer sb = new StringBuffer(A);
            char[] b = B.toCharArray();
            int i;
            if (A.length() < B.length()) {
                System.out.println("No");
            } else {
                for (i = 0; i < B.length(); i++) {
                    int m = sb.toString().indexOf(String.valueOf(b[i]));
                    if (m != -1) {
                        sb.deleteCharAt(m);
                    } else {
                        break;
                    }
                }
                if (i == B.length()) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
    }
}
