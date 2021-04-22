import java.lang.reflect.Array;
import java.util.Arrays;

public class 两数之和等于50 {
    public static void main(String[] args) {
        int[] arr = {4,1,2,7,3};
        int num = 5;
        int[][] a = new int[arr.length][2];
        int k = 0;
        Arrays.sort(arr);
        //  1,2,3,4,7
        int i = 0;
        int j = arr.length-1;
        while (i < j){
            if (arr[j] >= num) {
                j--;
            } else {
                if (num - arr[j] == arr[i]) {
                    a[k][0] = arr[i];
                    a[k][1] = arr[j];
                    k++;
                    j--;
                    i++;
                } else if (num - arr[j] > arr[i]) {
                    i++;
                } else {
                    j--;
                }

                /*if (num - arr[j] != arr[i]) {
                    i++;
                } else {
                    a[k][0] = arr[i];
                    a[k][1] = arr[j];
                    k++;
                    j--;
                    i++;
                }*/
            }
        }
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i+1; j < arr.length;j++) {
//                if (arr[i] + arr[j] == num) {
//                    a[k][0] = arr[i];
//                    a[k][1] = arr[j];
//                    k++;
//                }
//            }
//        }
        for (int n= 0; n < a.length; n++) {
            for (int m = 0; m < 2; m++) {
                System.out.println(a[n][m]);
            }
        }

    }
}
