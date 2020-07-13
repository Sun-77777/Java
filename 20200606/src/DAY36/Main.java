package DAY36;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            char[] arr = new char[26];
            Map<Character,Integer> map = new HashMap<>();
            for (int i = 0; i < 26; i++) {
                arr[i] = (char)('A' + i);
                map.put(arr[i],0);
            }
            char[] s = str.toCharArray();
            for (int i = 0; i < s.length; i++) {
                if (s[i] >= 'A' && s[i] <= 'Z') {
                    map.put(s[i],map.get(s[i]) + 1);
                }
            }
            for (int i = 0; i < 26; i++) {
                System.out.println(arr[i] + ":" + map.get(arr[i]));
            }
        }
    }
}
