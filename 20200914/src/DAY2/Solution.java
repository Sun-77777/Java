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
        String s = "";
        for (int i = 0; i < arr.length; i++) {
            s = s + String.valueOf(arr[i]);
        }
        int len = s.length();
        String str1 = s.substring(len-pushOffset%len);
        String str2 = s.substring(0,len-pushOffset%len);
        String ret = str1 + str2;
        int[] res = new int[ret.length()];
        for (int i = 0; i < ret.length(); i++) {
            char c = ret.charAt(i);
            res[i] = Integer.parseInt(String.valueOf(c));
        }
        return res;

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        Solution solution = new Solution();
        int[] r = solution.pushIntArray(arr,2);
        System.out.println(Arrays.toString(r));
    }
}