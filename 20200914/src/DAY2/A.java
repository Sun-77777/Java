package DAY2;

public class A {
    public static void main(String[] args) {
        int[] arr = {2,2,3,4,3};
        int ret = maxLength(arr);
        System.out.println(ret);
        
    }

    public static int maxLength(int[] arr) {
        int[] last = new int[100000];
        int n = arr.length;
        int res = 0;
        int start = 0;//窗口开始位置
        for (int i = 0; i < n; i++) {
            int index = arr[i];
            start = Math.max(start,last[index]);
            res = Math.max(res,i-start+1);
            last[index] = i+1;
        }
        return res;
    }
}
