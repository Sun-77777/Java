package DAY2;

public class A {
    public static void main(String[] args) {
        String input = "15 + 2 * 3";
        int ret = calculate(input);
        System.out.println(ret);
    }
    public static int calculate (String input) {
        // write code here
        String[] s = input.split(" ");
        String ss = String.valueOf(s);
        char[] c = ss.toCharArray();
        int result = 0;
        int j = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '*') {
                j = 1;
                result += Integer.parseInt(String.valueOf(c[i-1]))* Integer.parseInt(String.valueOf(c[i+1]));
            }
            if (c[i] == '+') {
                j = 1;
                result += Integer.parseInt(String.valueOf(c[i-1]));
            }
            if (c[i] == '-') {
                j = 1;
                result += Integer.parseInt(String.valueOf(c[i-1]));
                c[i+1] = (char) -c[i+1];
            }
            if (c[i] == '/') {
                j = 1;
                result += Integer.parseInt(String.valueOf(c[i-1]))/Integer.parseInt(String.valueOf(c[i+1]));
            }
        }
        String ret = null;
        if (j == 0) {
            for (int i = 0; i < c.length; i++) {
                ret = ret + String.valueOf(c[i]);
            }
            int n = Integer.parseInt(ret);
            int d = Integer.parseInt("3");
            System.out.println(d);
            return n;
        }
        return result;
    }



}
