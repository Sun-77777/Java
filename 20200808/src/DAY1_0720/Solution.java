package DAY1_0720;
//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非递减排序的数组的一个旋
//转，输出旋转数组的最小元素。 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的
//所有元素都大于0，若数组大小为0，请返回0。
public class Solution {
    public static int minNumberInRotateArray(int [] array) {
        if (array == null && array.length == 0) {
            return 0;
        }
        int left = 0;
        int right = array.length-1;
        int mid = 0;
        while(left < right) {
            if (right - left == 1) {
                mid = right;
                break;
            }

            if (array[left] == array[right] && array[left] == array[mid]) {
                int result = array[left];
                for (int i = left+1; i < right; i++) {
                    if (array[i] < result) {
                        result = array[i];
                    }
                }
                return result;
            }

            mid = (left + right)/2;
            if (array[mid] >= array[left]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return array[mid];

    }

    public static void main(String[] args) {
        int[] array = {3,4,5,1,2};
        int ret = minNumberInRotateArray(array);
        System.out.println(ret);
    }


}
