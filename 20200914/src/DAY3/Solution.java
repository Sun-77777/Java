package DAY3;

import java.util.*;

//[[0,4,5],[4,8,8],[8,6,1],[10,10,0]],[[12,11,16],[20,2,6],[9,2,6],[10,18,3],[8,14,9]]
//[-1,4,3,3,3]

//[[2,8,4],[2,5,0],[10,9,8]],[[2,11,3],[15,10,7],[9,17,12],[8,1,14]]
//[2,-1,3,-1]
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * func getTriggerTime(increase [][]int, requirements [][]int) []int
     * @param increase int整型二维数组 属性增加值
     * @param requirements int整型二维数组 剧情触发要求
     * @return int整型一维数组
     */
    public int[] getTriggerTime (int[][] increase, int[][] requirements) {
        // write code here
        int[][] arr = new int[3][3];
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = increase[i][j];
                }
            } else {
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = arr[i - 1][j] + increase[i][j];
                }
            }
        }
        //arr ok
        int count = 0;
        int[] ret = new int[requirements.length];
        int k = 0;
        while (k < arr.length) {
            for (int i = 0; i < requirements.length; i++) {
                for (int j = 0; j < requirements[0].length; j++) {
                    if (arr[k][j] > requirements[i][j]) {
                        count++;
                    }
                }
                if (count == 3) {
                    ret[i] = k;
                } else {
                    ret[i] = -1;
                }
            }
            k++;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] increase = {{0,4,5},{4,8,8},{8,6,1},{10,10,0}};
        int[][] requirements = {{12,11,16},{20,2,6},{9,2,6},{10,18,3},{8,14,9}};
        Solution solution = new Solution();
        int[] ret = solution.getTriggerTime(increase,requirements);
        System.out.println(Arrays.toString(ret));
    }
}