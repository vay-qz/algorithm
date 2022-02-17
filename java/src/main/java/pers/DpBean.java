package pers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiaozhe
 * @date 2022/2/17
 */
public class DpBean {
    /**688
     * todo
     * @param n
     * @param k
     * @param row
     * @param column
     * @return
     */
    public double knightProbability(int n, int k, int row, int column) {
        if (k == 0) {
            return 1;
        }
        double[] dp = new double[k + 1];
        dp[0] = 1;
        List<int[]> node = new ArrayList<>();
        node.add(new int[]{row, column});
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] * makeNow(n, node);
        }
        return dp[k];
    }

    int[] xx = {-1, -2, -2, -1, 1, 2, 2, 1};
    int[] yy = {2, 1, -1, -2, -2, -1, 1, 2};

    private double makeNow(int n, List<int[]> node) {
        double fm = node.size();
        List<int[]> newNode = new ArrayList<>();
        double res = 0;
        for (int[] xy : node) {
            int x = xy[0];
            int y = xy[1];
            double fz = 0;
            for (int i = 0; i < 8; i++) {
                int xxx = x + xx[i];
                int yyy = y + yy[i];
                if (xxx >= 0 && xxx < n && yyy >= 0 && yyy < n) {
                    fz++;
                    newNode.add(new int[]{xxx, yyy});
                }
            }
            res += fz / 8.0 / fm;
        }
        node.clear();
        node.addAll(newNode);
        return res;
    }
}
