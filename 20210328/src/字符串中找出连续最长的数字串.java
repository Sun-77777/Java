import java.util.Scanner;

public class 字符串中找出连续最长的数字串 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] c = str.toCharArray();

        int max = 0;
        int end = 0;
        for (int i = 0; i < c.length; i++) {
            int count = 0;
            if (c[i] >= '0' && c[i] <= '9') {
                count++;
                while (i < c.length-1 && c[i+1] >= '0' && c[i+1] <= '9') {
                    count++;
                    i++;
                }
            }
            if (max < count) {
                max = count;
                end = i;
            }
        }
        System.out.println(str.substring(end - max+1, end+1));
    }
}
