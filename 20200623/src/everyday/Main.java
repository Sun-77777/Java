package everyday;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double n = scan.nextDouble();
        String s = String.valueOf(n);
        String[] str = s.split("\\.");
        int len1 = str[0].length();
        int len2 = str[1].length();
        int num1 = Integer.parseInt(str[0]);
        int[] nn = new int[len1];
        for (int i = 0; i < len1; i++){
            nn[i] = num1%10;
            num1 = num1/10;
        }
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"壹");
        map.put(2,"贰");
        map.put(3,"叁");
        map.put(4,"肆");
        map.put(5,"伍");
        map.put(6,"陆");
        map.put(7,"柒");
        map.put(8,"捌");
        map.put(9,"玖");
        map.put(0,"零");
        Map<Integer,String> map2 = new HashMap<>();
        map2.put(0,"元");
        map2.put(1,"拾");
        map2.put(2,"佰");
        map2.put(3,"仟");
        map2.put(4,"万");
        map2.put(8,"亿");
        System.out.print("人民币");
        for (int i = len1-1; i >= 0; i--) {
            String value = map.get(nn[i]);
            String value2 = map2.get(i);
            if (value.equals("零")) {
                System.out.print(value);
            } else {
                System.out.print(value+value2);
            }
        }

    }
}
