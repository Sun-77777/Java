package DAY_0708;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,Integer> map = new LinkedHashMap<>();
        while (scanner.hasNext()) {
            String path = scanner.next();
            int id = path.lastIndexOf("\\");
            String filename = id == -1 ? path : path.substring(id + 1);
            int line = scanner.nextInt();
            String key = filename + " " + line;
            if (map.containsKey(key)) {
                map.put(key,map.get(key) + 1);
            } else {
                map.put(key,1);
            }
        }
        //排序
        List<Map.Entry<String,Integer>> list = new LinkedList<>();
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                return b.getValue() - a.getValue();
            }
        });

        //只输出前八条
        int m = 0;
        for (Map.Entry<String,Integer> entry : list) {
            if (m >= 8) {
                break;
            }
            String[] str = entry.getKey().split(" ");
            String filename = str[0];
            if (filename.length() > 16) {
                filename = filename.substring(filename.length()-16,filename.length());
            }
            String n = str[1];
            Integer count = entry.getValue();
            System.out.printf("%s %s %d\n",filename,n,count);
            m++;
        }
    }
}
