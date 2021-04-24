import java.util.ArrayList;

public class 删除偶数 {
    public static void main(String[] args) {
        int[] arr = {9,1,4,2,3,6,5,8,7};
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                list.add(arr[i]);
            }
        }
        for (int i : list) {
            System.out.println(i);
        }
    }

}
