package DAY36;

import java.util.Scanner;

public class Main16_10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        // substring(int beginIndex):
        // 返回一个字符串，该字符串是此字符串的子字符串
        // 从第三位开始（前两位是 0x, 不译）
        // parseInt(String s, int radix):
        // 将字符串参数解析为第二个参数指定的基数(16)中的有符号整数。
        int n = Integer.parseInt(s.substring(2),16);
        System.out.println(n);
    }
}
