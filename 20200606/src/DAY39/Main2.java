package DAY39;

public class Main2 {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[] ret = arrayPrint(arr,arr[0].length);
    }

    private static int[] arrayPrint(int[][] arr, int n) {
        int[] array = new int[n*n];
        int index = 0;
        int x = 0;
        int y = n-1;
        while (x < n) {
            int i = x;
            int j = y;
            while (i < n && j < n) {
                array[index] = arr[i][j];
                index++;
                i++;
                j++;
            }
            if (y > 0) {
                y--;
            } else {
                x++;
            }
        }
        return array;
    }
}
