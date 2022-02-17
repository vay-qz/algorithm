package pers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**56
 * todo
 * @author qiaozhe
 * @date 2022/2/17
 */
public class GreedyBean {

    /**56
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] te = new int[2];
            res.add(te);
            te[0] = intervals[i][0];
            int index = i + 1;
            while (index < intervals.length && intervals[index][0] <= intervals[i][1]) {
                index++;
                i++;
            }
            te[1] = intervals[i][1];
        }
        int[][] ress = new int[res.size()][];
        for (int i = 0; i < ress.length; i++) {
            ress[i] = res.get(i);
        }
        return ress;
    }

}
