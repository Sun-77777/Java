import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String,Integer> map = new HashMap<>();

        while (scan.hasNext()) {
            String strs = scan.nextLine();
            String[] str = strs.split(" ");
            for (int i = 0; i < str.length; i++) {
                if (!map.containsKey(str[i])) {
                    map.put(str[i],1);
                } else {
                    int value = map.get(str[i]);
                    map.put(str[i],value+1);
                }
            }
        }

        System.out.println(map.size());

    }
}
