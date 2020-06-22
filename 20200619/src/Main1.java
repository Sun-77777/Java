import java.util.Scanner;
public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int len = scan.nextInt();

        int max = 0;
        int bug = 0;
        char[] c = str.toCharArray();
        for (int i = 0; i <= c.length-len; i++) {
            int count = 0;
            for (int j = i; j < i + len; j++) {
                if (c[j] == 'C' || c[j] == 'G') {
                    count++;
                }
            }
            if (count > max) {
                max = count;
                bug = i;
            }
        }
        System.out.println(str.substring(bug,bug+len));
    }
}
