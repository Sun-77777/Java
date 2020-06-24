package Java16_0624;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String n = scan.nextLine();
        int len = Integer.parseInt(n);
        String[] strs = new String[len];
        int[] arr = new int[len];
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            strs[i] = scan.nextLine();
            String[] str = strs[i].split(" ");
            String ss = str[0];
            arr[i] = Integer.parseInt(str[1]);
            map.put(arr[i], ss);
        }
        Arrays.sort(arr);
        for (int i = len-1; i >= 0; i--) {
            String value = map.get(arr[i]);
            System.out.println(value + " " + arr[i]);
        }

    }

}
