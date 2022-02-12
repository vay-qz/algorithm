package pers;

import java.util.HashSet;
import java.util.List;

/**
 * @author qiaozhe
 * @date 2022/2/3
 */
public class ArrayBean {

    /**15
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        return null;
    }

    /**18 四数之和
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        return null;
    }

    /**378
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        int[] sort = new int[matrix.length * matrix[0].length];
        int index = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sort[index++] = matrix[i][j];
            }
        }
        for (int i = sort.length / 2; i >= 0; i--) {
            adjust(sort, i, sort.length);
        }
        for (int i = 1; i < k; i++) {
            int temp = sort[0];
            sort[0] = sort[sort.length - i];
            sort[sort.length - i] = temp;
            adjust(sort, 0, sort.length - i + 1);
        }
        return sort[0];
    }

    private void adjust(int[] sort, int i, int limit) {
        if (i > limit) {
            return;
        }
        if (i * 2 + 1 < limit && i * 2 + 2 < limit) {
            int low = sort[i * 2 + 1];
            int high = sort[i * 2 + 2];
            if (low > high) {
                if (high < sort[i]) {
                    swap(sort, i, i * 2 + 2);
                    adjust(sort, i * 2 + 2, limit);
                }
            } else {
                if (low < sort[i]) {
                    swap(sort, i, i * 2 + 1);
                    adjust(sort, i * 2 + 1, limit);
                }
            }
        } else if (i * 2 + 1 < limit) {
            if (sort[i * 2 + 1] < sort[i]) {
                swap(sort, i, i * 2 + 1);
                adjust(sort, i * 2 + 1, limit);
            }
        }
    }

    private void swap(int[] sort, int a, int b) {
        int temp = sort[a];
        sort[a] = sort[b];
        sort[b] = temp;
    }

    /**769
     * @param arr
     * @return
     */
    public int maxChunksToSorted(int[] arr) {
        int res = 0, max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = i;
            }
            if (max == i) {
                res++;
            }
        }
        return res;
    }

}
