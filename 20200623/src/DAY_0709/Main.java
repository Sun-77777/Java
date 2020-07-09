package DAY_0709;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int win = 0;
        int lose = 0;
        int ping = 0;
        String[] str1 = new String[n];
        String[] str2 = new String[n];
        Map<String,Integer> mapA = new HashMap<>();
        mapA.put("B",0);
        mapA.put("C",0);
        mapA.put("J",0);
        Map<String,Integer> mapB = new HashMap<>();
        mapB.put("B",0);
        mapB.put("C",0);
        mapB.put("J",0);
        for (int i = 0; i < n; i++) {
            str1[i] = in.next();
            str2[i] = in.next();
            if (str1[i].equals("C")) {
                if (str2[i].equals("C")) {
                    ping++;
                } else if (str2[i].equals("B")) {
                    lose++;
                    mapB.put(str2[i],mapB.get(str2[i])+1);
                } else {
                    win++;
                    mapA.put(str1[i],mapA.get(str1[i])+1);
                }
            } else if (str1[i].equals("B")) {
                if (str2[i].equals("C")) {
                    win++;
                    mapA.put(str1[i],mapA.get(str1[i])+1);
                } else if (str2[i].equals("B")) {
                    ping++;
                } else {
                    lose++;
                    mapB.put(str2[i],mapB.get(str2[i])+1);
                }
            } else {
                if (str2[i].equals("C")) {
                    lose++;
                    mapB.put(str2[i],mapB.get(str2[i])+1);
                } else if (str2[i].equals("B")) {
                    win++;
                    mapA.put(str1[i],mapA.get(str1[i])+1);
                } else {
                    ping++;
                }
            }
        }

        System.out.println(win + " " + ping + " " + lose);
        System.out.println(lose + " " + ping + " " + win);

        if (mapA.get("B") >= mapA.get("C")) {
            if (mapA.get("B") >= mapA.get("J")) {
                System.out.print("B ");
            } else {
                System.out.print("J ");
            }
        } else {
            if (mapA.get("C") >= mapA.get("J")) {
                System.out.print("C ");
            } else {
                System.out.print("J ");
            }
        }

        if (mapB.get("B") >= mapB.get("C")) {
            if (mapB.get("B") >= mapB.get("J")) {
                System.out.print("B");
            } else {
                System.out.print("J");
            }
        } else {
            if (mapB.get("C") >= mapB.get("J")) {
                System.out.print("C");
            } else {
                System.out.print("J");
            }
        }

    }
}
