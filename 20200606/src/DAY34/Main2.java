package DAY34;

import java.util.Scanner;
import java.lang.Math;
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str = in.nextLine();
        String[] s = str.split(" ");
        int[] num = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            num[i] = Integer.parseInt(s[i]);
        }
        double rr = Math.pow(num[3]-num[0],2) + Math.pow(num[4]-num[1],2) + Math.pow(num[5]-num[2],2);
        double r = Math.sqrt(rr);
        double v = (4.0/3) * Math.PI * Math.pow(r,3);
        System.out.println(String.format("%.3f",r));
        System.out.println(String.format("%.3f",v));

    }
}
