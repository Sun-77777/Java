package DAY_0706;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class M {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] s = new String[n];
        for (int i = 0; i < s.length; i++) {
            s[i] = scanner.next();
        }
        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() < o2.length()) {
                    return -1;
                }
                if (o1.length() > o2.length()) {
                    return 1;
                }
                return o1.compareTo(o2);
            }
        });
        for (String ss : s) {
            System.out.println(ss);
        }
    }
}
