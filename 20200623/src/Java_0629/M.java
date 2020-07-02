package Java_0629;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
public class M {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

            int n = scan.nextInt();
            Map<String,Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String name = scan.next();
                map.put(name,0);
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
            for (Map.Entry<String,Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
            if (count != 0) {
                System.out.println("Invalid : " + count);
            }

    }
}
