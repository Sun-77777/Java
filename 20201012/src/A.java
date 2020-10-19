import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int index = str.lastIndexOf("]");
        Map<Integer,Integer> map = new HashMap<>();
        char[] c = str.toCharArray();
        int count = 0;
        int key = 0;
        int value = 0;
        for (int i = 1; i < index; i++) {
            if (c[i] == '[') {
                count++;
                continue;
            } else if (c[i] == ',') {
                continue;
            } else if (c[i] == ']') {
                count--;
                continue;
            } else {
                if (count == 1) {
                    value = Integer.parseInt(String.valueOf(c[i]));
                    count++;
                    continue;
                }
                if (count == 2) {
                    key = Integer.parseInt(String.valueOf(c[i]));
                    count--;
                    map.put(key,value);
                }
            }
        }
        int k = str.lastIndexOf(",");
        int start = Integer.parseInt(str.substring(index+2,k));
        int end = Integer.parseInt(str.substring(k+1));

        int v = map.get(end);
        int num = 1;
        while (v != start) {
            v = map.get(v);
            num++;
        }
        System.out.println(num);

    }
}
