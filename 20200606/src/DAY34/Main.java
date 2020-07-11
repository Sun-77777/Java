package DAY34;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        Set<String> set = new LinkedHashSet<>();
        String s1 = str1.toUpperCase();
        String s2 = str2.toUpperCase();
        char[] s = s1.toCharArray();
        for (int i = 0; i < s.length;i++) {
            String ss = String.valueOf(s[i]);
            if (!s2.contains(ss)) {
                set.add(ss);
            }
        }
        //7_This_is_a_test
        //_hs_s_a_es
        for (String sss : set) {
            System.out.print(sss);
        }


    }

}
