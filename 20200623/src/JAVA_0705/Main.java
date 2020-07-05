package JAVA_0705;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int sum = scan.nextInt();
        int[] value = new int[n];
        long[] dp = new long[sum+1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            value[i] = scan.nextInt();
        }
        System.out.println(bag(value,n,sum));
    }

    private static long bag(int[] value, int n, int sum) {
        long[][] dp = new long[n+1][sum+1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j >= value[i]) {
                    dp[i][j] = dp[i-1][j-value[i]] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
