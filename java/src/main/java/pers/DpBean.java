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

    /**221
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = matrix[i][j] - '0';
                        if (dp[i][j] > max) {
                            max = dp[i][j];
                        }
                        continue;
                    }
                    int min = Integer.MAX_VALUE;
                    if (dp[i - 1][j] < min) {
                        min = dp[i - 1][j];
                    }
                    if (dp[i][j - 1] < min) {
                        min = dp[i][j - 1];
                    }
                    if (dp[i - 1][j - 1] < min) {
                        min = dp[i - 1][j - 1];
                    }
                    dp[i][j] = min + 1;
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                    }
                }
            }
        }
        return max * max;
    }

    /**1277
     * @param matrix
     * @return
     */
    public int countSquares(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = matrix[i][j];
                        sum += dp[i][j];
                        continue;
                    }
                    int min = Integer.MAX_VALUE;
                    if (dp[i - 1][j] < min) {
                        min = dp[i - 1][j];
                    }
                    if (dp[i][j - 1] < min) {
                        min = dp[i][j - 1];
                    }
                    if (dp[i - 1][j - 1] < min) {
                        min = dp[i - 1][j - 1];
                    }
                    dp[i][j] = min + 1;
                    sum += dp[i][j];
                }
            }
        }
        return sum;
    }


}
