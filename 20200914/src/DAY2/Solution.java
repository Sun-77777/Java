package DAY2;

import java.util.*;


public class Solution {
    /**
     * 数组内数据循环平移
     * @param arr int整型一维数组 输入数组
     * @param pushOffset int整型 位移长度
     * @return int整型一维数组
     */
    public int[] pushIntArray (int[] arr, int pushOffset) {
        // write code here
        int len = arr.length;
        int count = pushOffset % len;
        while (count > 0) {
            int tmp = arr[len - 1];
            for (int i = len - 1; i > 0; i--) {
                arr[i] = arr[i - 1];
            }
            arr[0] = tmp;
            count--;
        }
        return arr;
        /*if (pushOffset >= arr.length) {
            pushOffset = pushOffset%arr.length;
        }
        int[] a = new int[arr.length];
        for (int i = 0; i < pushOffset; i++) {
            a[i] = arr[arr.length-pushOffset+i];
        }
        int j = 0;
        for (int i = pushOffset; i < arr.length; i++) {
            a[i] = arr[j];
            j++;
        }
        return a;*/
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        Solution solution = new Solution();
        int[] r = solution.pushIntArray(arr,2);
        System.out.println(Arrays.toString(r));
    }
}