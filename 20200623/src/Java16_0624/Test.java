package Java16_0624;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        int[] gifts = {1,2,3,2,3,2,2};
        int ret  = getValue(gifts,7);
        System.out.println(ret);
    }


    public static int getValue(int[] gifts, int n) {
        // write code here
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(gifts[i])) {
                map.put(gifts[i],1);
            } else {
                int value = map.get(gifts[i]);
                map.put(gifts[i],value+1);
            }
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (entry.getValue() > n/2) {
                return entry.getKey();
            }
        }
        return 0;
    }

}
