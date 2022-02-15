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

    /**540
     * @param nums
     * @return
     */
    int target = 0;
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        findTarget(0, nums.length - 1, nums);
        return target;
    }

    private void findTarget(int head, int tail, int[] nums) {
        if (head > tail || head < 0 || tail > nums.length - 1) {
            return;
        }
        int mid = (head + tail) / 2;
        if (mid == 0 && nums[mid] != nums[mid + 1]) {
            target = nums[mid];
            return;
        }
        if (mid == nums.length - 1 && nums[mid] != nums[mid - 1]) {
            target = nums[mid];
            return;
        }
        if (nums[mid] == nums[mid + 1]) {
            findTarget(head, mid - 1, nums);
            findTarget(mid + 2, tail, nums);
            return;
        } else if (nums[mid] == nums[mid - 1]) {
            findTarget(head, mid - 2, nums);
            findTarget(mid + 1, tail, nums);
        } else {
            target = nums[mid];
            return;
        }
    }

    /**33
     * @param nums
     * @param target
     * @return
     */
    int res = -1;
    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        find(nums, 0, nums.length - 1, target);
        return res;
    }

    private void find(int[] nums, int head, int tail, int target) {
        if (head > tail) {
            return;
        }
        int mid = (head + tail) / 2;
        if (nums[mid] == target) {
            res = mid;
            return;
        }
        if (mid - 1 >= 0 && nums[head] <= nums[mid - 1] ) {
            if (target >= nums[head] && target <= nums[mid - 1]) {
                find(nums, head, mid - 1, target);
            } else {
                find(nums, mid + 1, tail, target);
            }
        }
        if (mid + 1 < nums.length && nums[mid + 1] <= nums[tail]) {
            if (target >= nums[mid + 1] && target <= nums[tail]) {
                find(nums, mid + 1, tail, target);
            } else {
                find(nums, head, mid - 1, target);
            }
        }
    }

    /**34
     * todo
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {

    }


}
