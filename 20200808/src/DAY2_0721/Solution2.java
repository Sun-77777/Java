package DAY2_0721;
//替换空格
public class Solution2 {
    public String replaceSpace(StringBuffer str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }
        int new_length = str.length() + 2 * count;
        int old_end = str.length() - 1;
        int new_end = new_length - 1;

        str.setLength(new_length);
        while (old_end >= 0 && new_end >= 0) {
            if (str.charAt(old_end) == ' ') {
                str.setCharAt(new_end--,'0');
                str.setCharAt(new_end--,'2');
                str.setCharAt(new_end--,'%');
                old_end--;
            } else {
                str.setCharAt(new_end,str.charAt(old_end));
                new_end--;
                old_end--;
            }
        }
        return str.toString();

    }
}
