import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = new String[100];
        int i = 0;
        while (scanner.hasNext()) {
            strings[i] = scanner.nextLine();
            i++;
        }
        String[] users = new String[i];
        String[] devices = new String[i];
        String user = "";
        for (int j = 0; j <= i; j++) {
            int index = strings[i].indexOf(",");
            if (index != -1) {
                users[j] = strings[i].substring(0,index);
                devices[j] = strings[i].substring(index);
            } else {
                user = strings[j];
            }
        }
        int m = 0;
        for (int k = 0; k < i-1; k++) {
            if (user.equals(users[k])) {
                m = k;
                break;
            }
        }
        int count = 0;
        for (int k = 0; k < i-1; k++) {
            if (devices[m] == devices[k]) {
                count++;
            }
        }
        System.out.println(count);
    }
}
