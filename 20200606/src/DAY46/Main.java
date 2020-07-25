package DAY46;

import java.util.Scanner;
import java.util.Map;
import java.util.LinkedHashMap;

//1、 记录最多8条错误记录，循环记录（或者说最后只输出最后出现的八条错误记录），
// 对相同的错误记录（净文件名（保留最后16位）称和行号完全匹配）只记录一条，错误计数增加；
//
//2、 超过16个字符的文件名称，只记录文件的最后有效16个字符；
//
//3、 输入的文件可能带路径，记录文件名称不能带路径。
public class Main {
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
        int count = 0;
        for (Map.Entry<String,Integer> entry : map.entrySet()) {
            count++;
            if (count > map.size()-8) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }
}