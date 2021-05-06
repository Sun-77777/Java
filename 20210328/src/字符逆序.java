import java.util.Scanner;

public class 字符逆序 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        //I am Student
        //Student am I
        StringBuffer sb = new StringBuffer();
        String[] s = str.split(" ");
        for (int i = s.length-1; i >= 0; i--) {
            sb.append(s[i]);
            if (i != 0) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}
