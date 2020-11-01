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
}
