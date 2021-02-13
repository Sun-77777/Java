import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] c = str.toCharArray();
        int count = 0;
        int max = 0;
        int end = 0;
        for (int i = 0; i < c.length; i++) {
            count = 0;
            while (c[i] >= '0' && c[i] <= '9') {
                count++;
                i++;
            }
            if (count > max) {
                max = count;
                end = i;
            }
        }
        System.out.println(str.substring(end-max,end) + "," + max);
    }
}
