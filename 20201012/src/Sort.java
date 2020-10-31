public class Sort {
    public static void main(String[] args) {

    }
    public static void insert(int[] array) {
         for (int i = 1; i < array.length; i++) {
             int v = array[i];
             for (int j = i-1; j >= 0; j--) {
                 if (array[j] > v) {
                     array[j+1] = array[j];
                 }
             }
         }
    }
}
