package Java_0629;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

            int num = scan.nextInt();
            int oper  = scan.nextInt();
            int[] arr = new int[num];
            for (int i = 0; i < num; i++) {
                arr[i] = scan.nextInt();
            }
            for (int i = 0; i < oper; i++) {
                String c = scan.next();
                int a = scan.nextInt();
                int b = scan.nextInt();
                if (c.equals("Q")) {
                    int s = Math.min(a,b);
                    int e = Math.max(a,b);
                    int max = 0;
                    for (int j = s-1; j < e; j++) {
                        max = Math.max(max,arr[j]);
                    }
                    System.out.println(max);
                }
                if (c.equals("U")) {
                    arr[a-1] = b;
                }
            }

    }
}
