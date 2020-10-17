import java.util.*;

public class Robot {
    public int countWays(int x, int y) {
        // write code here
        int[][] ret = new int[x][y];
        for (int i = 0; i < x; i++) {
            ret[i][0] = 1;
        }
        for (int i = 0; i < y; i++) {
            ret[0][i] = 1;
        }
        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                ret[i][j] = ret[i-1][j] + ret[i][j-1];
            }
        }
        return ret[x-1][y-1];
    }
}