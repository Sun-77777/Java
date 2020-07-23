package DAY1_0720;
//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位
//于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
public class Solution3 {
    public void reOrderArray(int [] array) {
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                int j = i;
                int tmp = array[i];
                while (j > k) {
                    array[j] = array[j-1];
                    j--;
                }
                array[k++] = tmp;
            }
        }
    }
}
