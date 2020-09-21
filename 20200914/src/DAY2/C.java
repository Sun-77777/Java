package DAY2;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        char[] c = str.toCharArray();
        int count = 0;
        int end = 0;
        int max = 0;
        int i = 0;
        for (i = 0; i < c.length; i++) {
            if (c[i] >= '0' && c[i] <= '9') {
                count = 0;
                while (i < c.length && c[i] >= '0' && c[i] <= '9') {
                    count++;
                    i++;
                }
                if (max < count) {
                    max = count;
                    end = i;
                }
            }
        }
        System.out.println(str.substring(end - max , end));
    }
}
