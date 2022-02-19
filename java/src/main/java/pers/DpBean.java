package pers;

/**
 * @author qiaozhe
 * @date 2022/2/17
 */
public class DpBean {
    /**688
     * @param n
     * @param k
     * @param row
     * @param column
     * @return
     */

    int[] xx = {-1, -2, -2, -1, 1, 2, 2, 1};
    int[] yy = {2, 1, -1, -2, -2, -1, 1, 2};

    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[k + 1][n][n];
        for (int p = 0; p <= k; p++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (p == 0) {
                        dp[p][i][j] = 1;
                    } else {
                        double res = 0;
                        for (int t = 0; t < 8; t++) {
                            int x = i + xx[t];
                            int y = j + yy[t];
                            if (x >= 0 && x < n && y >= 0 && y < n) {
                                res += dp[p - 1][x][y] / 8;
                            }
                        }
                        dp[p][i][j] = res;
                    }
                }
            }
        }
        return dp[k][row][column];
    }


}
