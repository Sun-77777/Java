package Java_0629;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a = scan.nextInt();
        int c = a;
        for (int i = 0; i < n; i++) {
            int b = scan.nextInt();
            if (c >= b) {
                c = c + b;
            } else {
                c = c + cal(c,b);
            }
        }
        System.out.print(c + " ");
    }
    public static int cal(int c,int b) {
        int tmp = 0;
        while (c > 0) {
            tmp = c;
            c = b%c;
            b = tmp;
        }
        return b;
        /*for (int i = c; i >= 1; i--) {
            if (b % i == 0) {
                if (c % i == 0) {
                    return i;
                }
            }
        }
        return 0;*/
    }
}

