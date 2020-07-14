package DAY37;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (a == 1) {
                list.add(b);
            }
            if (a == 2) {
                list.remove(searchIndex(list,b));
            }
            judge(list);
        }
    }

    private static void judge(List<Integer> list) {
        int max = 0;
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            if (max < list.get(i)) {
                max = list.get(i);
            }
            sum = sum + list.get(i);
        }
        sum = sum - max;
        if (sum > max) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static int searchIndex(List<Integer> list, int b) {
        for (int i = 0; i < list.size(); i++) {
            if (b == list.get(i)) {
                return i;
            }
        }
        return -1;
    }
}
