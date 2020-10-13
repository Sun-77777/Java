import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nstr = scanner.nextLine();
        int n = Integer.parseInt(nstr);
        int len = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            String str = scanner.nextLine();
            int start = str.indexOf("[");
            int end = str.indexOf("]");
            int num = Integer.parseInt(str.substring(start+1,end));

            if (!str.contains("=")) {
                len = num;
            } else {
                if (len < num) {
                    count = i+1;
                }
            }
        }
        System.out.println(count);
    }
}
