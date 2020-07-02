package Java_0629;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
public class M {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

            int n = scan.nextInt();
            String[] arr = new String[n];
            Map<String,Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                arr[i] = scan.next();
                map.put(arr[i],0);
            }
            int m = scan.nextInt();
            int count = 0;
            for (int i = 0; i < m; i++) {
                String key = scan.next();
                if (map.containsKey(key)) {
                    int value = map.get(key);
                    map.put(key,value+1);
                } else {
                    count++;
                }
            }
            for (int i = 0; i < n; i++) {
                System.out.println(arr[i] + " : " + map.get(arr[i]));
            }


            System.out.println("Invalid : " + count);


    }
}
