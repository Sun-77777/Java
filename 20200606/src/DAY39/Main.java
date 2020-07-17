package DAY39;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String str = scan.nextLine();
            char[] cc = str.toCharArray();

            int len = cc.length;
            int mid = len/2;
            int left = mid-1;
            int right = mid;
            if (len % 2 == 0) {
                right = right + 1;
            }
            while (right < cc.length && left >= 0 && cc[left] == cc[right]) {
                left--;
                right++;
            }
            if (left == 0 || right == cc.length-1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }



        }

    }
}
