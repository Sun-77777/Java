import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String addend = scan.nextLine();
        String augend = scan.nextLine();
        String ret = AddLongInteger(addend,augend);
        System.out.println(ret);
    }
    public static String AddLongInteger(String addend,String augend) {
        int cc = 0;
        if (addend.length() < augend.length()) {
            String tmp = addend;
            addend = augend;
            addend = tmp;
        }
        char[] chars1 = addend.toCharArray();
        char[] chars2 = augend.toCharArray();

        int[] ss = new int[chars1.length+1];
        int i = 0;
        for (i = chars1.length-1; i >= 0; i--) {
            for (int j = chars2.length-1; j >= 0; j--) {
                String s1 = String.valueOf(chars1[i]);
                int aa = Integer.parseInt(s1);
                String s2 = String.valueOf(chars2[j]);
                int bb = Integer.parseInt(s2);
                int sum = aa + bb + cc;
                if (sum > 10) {
                    cc = 1;
                    sum = sum % 10;
                } else {
                    cc = 0;
                }
                ss[i] = sum;
                i--;
            }
            break;
        }
        StringBuffer sb = new StringBuffer();

        if (i == -1) {
            ss[0] = cc;
            for (int k = 0; k < ss.length; k++) {
                if (ss[0] == 0) {
                    k++;
                }
                sb.append(ss[k]);
            }
            return sb.toString();
        } else {
            if (cc == 1) {
                
            }
        }
        return null;
    }
}
