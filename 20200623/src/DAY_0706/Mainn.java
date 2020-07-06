package DAY_0706;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Mainn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        BigInteger[] num = new BigInteger[n];
        for (int i = 0; i < n; i++) {
            num[i] = scanner.nextBigInteger();
        }
        Arrays.sort(num);
         for (int i = 0; i < n; i++) {
            System.out.println(num[i]);
        }
    }
}
