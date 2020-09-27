package DAY4;

import java.util.Scanner;
import java.util.Arrays;
public class Solution {
    // 1,3,5    2,4,6
    public void merge(int A[], int m, int B[], int n) {
        if (m == 0) {
            System.out.println(Arrays.toString(B));
            return;
        }
        if (n == 0) {
            System.out.println(Arrays.toString(A));
            return;
        }
        int[] res = new int[m+n];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n) {
            if (A[i] < B[j]) {
                res[k] = A[i];
                i++;
            } else {
                res[k] = B[j];
                j++;
            }
            k++;
        }
        if (j < n) {
            for (; k < m + n; k++) {
                res[k] = B[j];
                j++;
            }
            System.out.println(Arrays.toString(res));
            return;
        }
        if (i < m) {
            for (; k < m + n; k++) {
                res[k] = B[j];
                j++;
            }
            System.out.println(Arrays.toString(res));
            return;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = {1};
        int[] B = {2};
        solution.merge(A,1,B,1);
    }
}