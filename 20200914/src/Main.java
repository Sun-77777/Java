import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String str1 = scan.nextLine();
        String str2 = scan.nextLine();
        int n = Integer.parseInt(s);
        String[] s1 = str1.split(" ");
        String[] s2 = str2.split(" ");
        int max = 0;
        int m = 0;
        while (m < s1.length) {
            int count = 0;
            int k = 0;
            int j = 0;
            for (int i = m; i < s1.length; i++) {

                for (j = k; j < s2.length; j++) {
                    if (!s2[j].equals(s1[i])) {
                        continue;
                    } else {
                        count++;
                        i++;
                        k = j+1;
                    }
                }
            }
            if (max < count) {
                max = count;
            }
            m++;
        }
        System.out.println(max);
    }
}
//a b c d e f g
//b d a c f g e