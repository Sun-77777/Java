package DAY2_0721;

public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        int target = array[0];
        int time = 1;
        for (int i = 1; i < array.length; i++) {
            if (time == 0) {
                target = array[i];
                time = 1;
            } else if (array[i] == target) {
                time++;
            } else {
                time--;
            }
        }
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (target == array[i]) {
                count++;
            }
        }
        return count > array.length / 2 ? target : 0;
    }
}
