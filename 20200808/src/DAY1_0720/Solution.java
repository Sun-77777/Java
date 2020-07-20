package DAY1_0720;

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
