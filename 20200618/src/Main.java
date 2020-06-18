import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int n = scan.nextInt();
        int[] score = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(scan.next());
            list.add(score[i]);
        }
        int num = scan.nextInt();
        if (!list.contains(num)) {
            System.out.println(0);
            return;
        } else {
            for (int i = 0; i < n; i++) {
                if (score[i] == num) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
