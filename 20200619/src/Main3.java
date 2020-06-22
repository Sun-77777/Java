public class Main3 {
    public static void main(String[] args) {
        double ret = sum();
        System.out.println(10 * 30);
        System.out.println(ret);

    }
    public static double sum() {
        double ss = 0;
        for (int i = 0; i < 30; i++) {
            double tt =  Math.pow(2,i);
            ss = ss+tt;
        }
        return ss;
    }
}
