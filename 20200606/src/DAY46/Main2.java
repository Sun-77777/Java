package DAY46;

import java.util.Scanner;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map.Entry;
// 结果根据数目从多到少排序，数目相同的情况下，按照输入第一次出现顺序排序。
//
//    如果超过8条记录，则只输出前8条记录.
//
//    如果文件名的长度超过16个字符，则只输出后16个字符
public class Main2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String,Integer> map = new LinkedHashMap<>();
        while(scan.hasNext()) {

            String str = scan.nextLine();
            int s = str.lastIndexOf("\\");
            String[] file = str.substring(s+1).split(" ");
            String filename = file[0];
            String line = file[1];
            if (filename.length() > 16) {
                filename = filename.substring(filename.length() - 16) + " " + line;
            } else {
                filename = filename + " " + line;
            }
            if (!map.containsKey(filename)) {
                map.put(filename,1);
            } else {
                map.put(filename,map.get(filename)+1);
            }
        }

        List<Map.Entry<String,Integer>> list = new LinkedList<Map.Entry<String,Integer>>(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<String,Integer>>(){
            public int compare(Entry<String,Integer> a,Entry<String,Integer> b) {
                return b.getValue() - a.getValue();
            }
        });
        int m = 0;
        for (Map.Entry<String,Integer> entry : list) {
            if (m >= 8) {
                break;
            }
            System.out.println(entry.getKey() + " " + entry.getValue());
            m++;
        }
    }
}
