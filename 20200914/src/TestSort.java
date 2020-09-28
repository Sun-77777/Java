import java.util.Arrays;

public class TestSort {

    public static void insertSort(int[] array) {
        for (int bound = 1; bound < array.length; bound++) {
            int v = array[bound];
            int cur = bound - 1;
            for (; cur >= 0; cur--) {
                if (v < array[cur]) {
                    array[cur + 1] = array[cur];
                } else {
                    break;
                }
            }
            array[cur + 1] = v;
        }
    }

    public static void selectSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = bound + 1; cur < array.length; cur++) {
                if (array[bound] > array[cur]) {
                    int tmp = array[bound];
                    array[bound] = array[cur];
                    array[cur] = tmp;
                }
            }
        }
    }

    public static void bubbleSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = array.length - 1; cur > bound; cur--) {
                if (array[cur] < array[cur - 1]) {
                    int tmp = array[cur];
                    array[cur] = array[cur - 1];
                    array[cur - 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {9,5,2,7,3,6,8};
        //insertSort(array);
        //selectSort(array);
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
