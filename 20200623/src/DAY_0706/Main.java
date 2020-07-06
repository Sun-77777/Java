package DAY_0706;

import java.util.Scanner;

public class Main {
    //字符转换成二进制字符串
    //String d = Integer.toBinaryString(c);
    //补够7位二进制
    //String e = String.format("%07d",Integer.parseInt(d));
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            String binaryString = Integer.toBinaryString(c[i]);
            String ss = String.format("%07d",Integer.parseInt(binaryString));
            int count = 0;
            for (int j = 0; j < ss.length(); j++) {
                if (ss.charAt(j) == '1') {
                    count++;
                }
            }
            System.out.println(count%2 == 1 ? "0" + ss : "1" + ss);
        }


    }

}
