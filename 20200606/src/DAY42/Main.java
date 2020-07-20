package DAY42;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String str1 = scan.nextLine();
            String str2 = scan.nextLine();
            char[] c1 = str1.toCharArray();
            char[] c2 = str2.toCharArray();
            StringBuffer sb1 = new StringBuffer();
            StringBuffer sb2 = new StringBuffer();
            for (int i = 0; i < c1.length; i++) {
                if (c1[i] >= 'A' && c1[i] <= 'Y') {
                    sb1.append((char) (c1[i] + 1 + 32));
                }
                if (c1[i] == 'Z') {
                    sb1.append('a');
                }
                if (c1[i] >= 'a' && c1[i] <= 'y') {
                    sb1.append((char) (c1[i] + 1 - 32));
                }
                if (c1[i] == 'z') {
                    sb1.append('A');
                }

                if (c1[i] >= '0' && c1[i] < '9') {
                    sb1.append((char) (c1[i] + 1));
                }
                if (c1[i] == '9') {
                    sb1.append('0');
                }
            }
            System.out.println(sb1.toString());
            for (int i = 0; i < c2.length; i++) {
                if (c2[i] >= 'B' && c2[i] <= 'Z') {
                    sb2.append((char) (c2[i] - 1 + 32));
                }
                if (c2[i] == 'A') {
                    sb2.append('z');
                }
                if (c2[i] >= 'b' && c2[i] <= 'z') {
                    sb2.append((char) (c2[i] - 1 - 32));
                }
                if (c2[i] == 'a') {
                    sb2.append('Z');
                }
                if (c2[i] > '0' && c2[i] <= '9') {
                    sb2.append((char) (c2[i] - 1));
                }
                if (c2[i] == '0') {
                    sb2.append('9');
                }

            }
            System.out.println(sb2.toString());
        }


    }
}