package DAY38;

public class Main {
    public static void main(String[] args) {
        String iniString = "hello I am hqq";
        String ret = replaceSpace(iniString,iniString.length());
        System.out.println(ret);

    }

    private static String replaceSpace(String iniString, int length) {
        String result = iniString.replaceAll(" ","%20");
        return result;
    }
}
