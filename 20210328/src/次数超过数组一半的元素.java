import java.util.Arrays;

public class 次数超过数组一半的元素 {
    public static void main(String[] args) {
        int[] array = {1,2,1,2,5,2,3,2,2,7,2};
        System.out.println(MoreThanHalfNum_Solution(array));

    }
    public static int MoreThanHalfNum_Solution(int [] array) {
        int n = array.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return array[0];
        }
        Arrays.sort(array);
        for (int i = 0; i < n/2; i++) {
            if (array[i] == array[i+n/2]) {
                return array[i];
            }
        }
        return 0;
    }
}
