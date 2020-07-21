package DAY1_0720;

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
