import java.util.Arrays;

public class Test1 {

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < array.length-i-1; j++) {
                if (array[j] > array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }
    public static void main(String[] args) {
        int[] array = {3,6,8,4,1,9,7};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
    
}
