package java16;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String str = scan.nextLine();
            char[] c = str.toCharArray();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < c.length; i++) {
                if (c[i] >= 'F' && c[i] <= 'Z') {
                    char cc = (char) (c[i] - 5);
                    sb.append(cc);
                } else if (c[i] < 'F' && c[i] >= 'A') {
                    char cc = (char) (c[i] +26 -5);
                    sb.append(cc);
                } else {
                    sb.append(c[i]);
                }
            }
            System.out.println(sb.toString());
        }

    }
}
