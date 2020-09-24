package DAY3;

import java.util.*;

public class BinarySearch {
    public int getPos(int[] A, int n, int val) {
        // write code here
        int left = 0;
        int right = n;
        int mid = -1;
        while (left <= right) {
            mid = (left + right)/2;
            if (A[mid] < val) {
                left = mid + 1;
            } else if (A[mid] > val) {
                right = mid - 1;
            } else {
                break;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        int[] A = {9,13,21,31};
        BinarySearch binarySearch = new BinarySearch();
        int ret = binarySearch.getPos(A,4,9);
        System.out.println(ret);
    }
}