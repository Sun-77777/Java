package Java_0608;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestMap {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] s = str.split(" ");
        int n = s.length;
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(s[i]);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(num[i])) {
                map.put(num[i],1);
            } else {
                int count = map.get(num[i]);
                map.put(num[i],count+1);
            }
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (entry.getValue() >= n/2) {
                System.out.println(entry.getKey());
                return;
            }
        }

//        for (int j = 0; j < n; j++) {
//            int count = map.get(arr[j]);
//            if (count != 0) {
//                map.put(arr[j],count+1);
//            } else {
//                map.put(arr[j], 1);
//            }
//        }
//
//        for (int k = 0; k < n; k++) {
//            if (map.get(arr[k]) >= n/2 ) {
//                System.out.println(arr[k]);
//            }
//        }

    }
}
