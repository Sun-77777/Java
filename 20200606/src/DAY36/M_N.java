package DAY36;

import java.util.Scanner;

public class M_N {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] ss = s.split(" ");
        String n = in.nextLine();
        Long num = Long.parseLong(n,Integer.parseInt(ss[0]));
        String t = Long.toString(num,Integer.parseInt(ss[1]));
        System.out.println(t);
    }
}
