package java16;

import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.nextLine();
        String str2 = scan.nextLine();
        int a = str1.length();
        int b = str2.length();
        StringBuffer sb = new StringBuffer(str1);
        char[] c = str2.toCharArray();
        int count = 0;
        for (int i = 0; i < c.length; i++) {
            int index = sb.toString().indexOf(c[i]);
            if (index != -1) {
                if (sb.length() > 0) {
                    sb.deleteCharAt(index);
                }
            } else {
                count++;
            }
        }
        if (count != 0) {
            System.out.println("No" + " " + count);
        } else {
            System.out.println("Yes" + " " + (a-b));
        }
    }
}
