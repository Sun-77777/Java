import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String str = scan.nextLine();
            char[] ch = str.toCharArray();
            int count = 0;
            int max = 0;
            int end = 0;
            for (int i = 0; i < ch.length; i++) {
                if (ch[i] >= '0' && ch[i] <= '9') {
                    while (i < ch.length && ch[i] >= '0' && ch[i] <= '9') {
                        count++;
                        i++;
                    }
                    if (max < count) {
                        max = count;
                        end = i;
                    }
                    count = 0;
                }
            }
            System.out.println(str.substring(end - max,end));
        }
    }
}
