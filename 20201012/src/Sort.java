public class Sort {
    public static void main(String[] args) {

    }
    public static void insert(int[] array) {
         for (int i = 1; i < array.length; i++) {
             int v = array[i];
             int j =i - 1;
             for (; j >= 0; j--) {
                 if (array[j] > v) {
                     array[j+1] = array[j];
                 }
             }
             array[j+1] = v;
         }
    }
    public static void shellSort(int[] array) {
        int gap = array.length;
        while (gap > 1) {
            insertSortGap(array,gap);
            gap = gap / 2;
        }
    }

    public static void insertSortGap(int[] array,int gap) {
        for (int i = gap; i < array.length; i++) {
            int v = array[i];
            int j = i - gap;
            for (; j >= 0; j -= gap) {
                if (array[j] > v) {
                    array[j + gap] = array[j];
                }
            }
            array[j + gap] = v;
        }
    }
}
