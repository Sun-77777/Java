import java.util.Scanner;

public class 字符串压缩 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        //aaaabbcccd
        int count = 1;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == str.length()-1) {
                    sb.append(count);
                    sb.append(c);
            } else {
                if (c == str.charAt(i + 1)) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(c);
                    count = 1;
                }
            }
        }
        System.out.println(sb.toString());
    }
}
