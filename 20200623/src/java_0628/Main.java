package java_0628;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] s = str.split(" ");
        int A1 = 0;
        int A2 = 0;
        int A3 = 0;
        int A4 = 0;
        int A5 = 0;
        int flag = 1;
        int count = 0;
        for (int i = 0; i < s.length; i++) {
            int num = Integer.parseInt(s[i]);
            int n = num%5;
            if (n == 0) {
                if (num % 2 == 0) {
                    A1 += num;
                }
            }
            if (n == 1) {
                A2 = A2 + (flag)*num;
                flag = -flag;
            }
            if (n == 2) {
                A3++;
            }

            if (n == 3) {
                count++;
                A4 = A4 + num;
            }
            if (n == 4) {
                if (A5 < num) {
                    A5 = num;
                }
            }
        }

        if (A1 != 0) {
            System.out.print(A1 +" ");
        } else {
            System.out.print("N" + " ");
        }

        if (A2 != 0) {
            System.out.print(A2 +" ");
        } else {
            System.out.print("N" + " ");
        }
        if (A3 != 0) {
            System.out.print(A3 +" ");
        } else {
            System.out.print("N" + " ");
        }
        if (A4 != 0) {
            float cc = count;
            System.out.print( (A4/cc) +" ");
        } else {
            System.out.print("N" + " ");
        }
        if (A5 != 0) {
            System.out.print(A5);
        } else {
            System.out.print("N");
        }

    }
}
