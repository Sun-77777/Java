public class M {
    public static void main(String[] args) {
        int m = 2;
        int n = 1;
        int ret = uniquePaths(m,n);
        System.out.println(ret);
    }
    public static int uniquePaths (int m, int n) {
        // write code here
        int[][] F = new int[m][n];
        for (int i = 0; i < m; i++) {
            F[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            F[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {




                
                F[i][j] = F[i-1][j] + F[i][j-1];
            }
        }
        return F[m-1][n-1];
    }
}
