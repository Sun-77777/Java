package JAVA_0703;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //String str1 = scan.nextLine();
        String str2 = scan.nextLine();
        //System.out.println(convertIp10(str1));
        System.out.println(convertIp(str2));

    }

     private static String convertIp(String str2) {
        StringBuffer sb = new StringBuffer();
        Long n = Long.parseLong(str2);

    }

    private static long convertIp10(String str1) {
        String[] s = str1.split("\\.");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length; i++) {
            sb.append(binaryString(s[i]
            ));//把10进制数转二进制字符串
        }
        return Long.parseLong(sb.toString(),2);
    }
    private static String binaryString(String s) {
        StringBuffer sb = new StringBuffer();
        int num = Integer.parseInt(s);
        int k = 1 << 7;
        for (int i = 0; i < 8; i++) {
            int flag = (num&k) == 0 ? 0 : 1;
            sb.append(flag);
            num = num << 1;
        }
        return sb.toString();
    }

}
