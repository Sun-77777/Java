import java.util.Scanner;

public class 统计回文 {

        public static void main (String[] args) {
            Scanner scan = new Scanner(System.in);
            String A = scan.nextLine();
            String B = scan.nextLine();
            int count = 0;
            for (int i = 0; i <= A.length(); i++) {
                StringBuffer sb = new StringBuffer(A);
                sb.insert(i,B);
                if (isHuiWen(sb.toString())) {
                    count++;
                }
            }
            System.out.println(count);
        }
        public static boolean isHuiWen(String str) {
            char[] c = str.toCharArray();
            int i = 0;
            int j = c.length - 1;
            while (i < j) {
                if (c[i] != c[j]) {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }

}
