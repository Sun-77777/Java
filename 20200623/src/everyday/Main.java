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
        int num2 = Integer.parseInt(str[1]);
        int[] nn = new int[len1];
        int[] mm = new int[len2];
        for (int i = 0; i < len1; i++) {
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
        Map<Integer,String> map3 = new HashMap<>();
        map3.put(0,"分");
        map3.put(1,"角");
        System.out.print("人民币");

        if (num1 != 0) {
            for (int i = len1-1; i >= 0; i--) {
                String value = map.get(nn[i]);
                String value2 = map2.get(i);
                if (value.equals("零")) {
                    if (value2.equals("元")) {
                        System.out.print("元");
                    } else {
                        while (value.equals("零")) {
                            i--;
                            value = map.get(nn[i]);
                        }
                        value2 = map2.get(i);
                        System.out.print(value + value2);
                    }

                } else {
                    System.out.print(value + value2);
                }
            }
        }


        if (num2 == 0) {
            System.out.print("整");
        } else if (len2 == 1) {
            int a = num2%10;
            String value = map.get(a);
            System.out.print(value + "分");
        } else {
            for (int i = 0; i < len2 ; i++) {
                mm[i] = num2%10;
                num2 = num2/10;
            }
            for (int i = len2-1; i >= 0; i--) {
                String value = map.get(mm[i]);
                String value2 = map3.get(i);
                if (!value.equals("零")) {
                    System.out.print(value+value2);
                }
            }
        }



    }
}
