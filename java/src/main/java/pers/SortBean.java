package pers;

/**排序
 * @author qiaozhe
 * @date 2022/1/17
 */
public class SortBean {

    /**912
     * @param nums
     * @return
     */
    public int[] sortArray(int[] nums) {
        return quickSort(nums);
    }

    /**快排
     * @param nums
     * @return
     */
    public int[] quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int head, int tail) {
        if (head >= tail) {
            return;
        }
        int t = head;
        int tv = nums[t];
        int p = head;
        int q = tail;
        while (head < tail) {
            while (head < tail && nums[tail] > tv) {
                tail--;
            }
            while (head < tail && nums[head] <= tv) {
                head++;
            }
            swap(nums, head, tail);
        }
        swap(nums, t, head);
        quickSort(nums, p, head - 1);
        quickSort(nums, head + 1, q);
    }

    private void swap(int[] nums, int t, int head) {
        int i = nums[t];
        nums[t] = nums[head];
        nums[head] = i;
    }

    /**堆排序
     * @param nums
     * @return
     */
    public int[] heapSort(int[] nums) {
        for (int i = nums.length / 2; i >= 0; i--) {
            down(nums, i, nums.length);
        }
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            down(nums, 0, i);
        }
        return nums;
    }

    private void down(int[] nums, int i, int length) {
        if (i * 2 + 1 >= length) {
            return;
        }
        int index = i * 2 + 1;
        if ((i * 2 + 2) < length && nums[i * 2 + 1] < nums[i * 2 + 2]) {
            index = i * 2 + 2;
        }
        if (nums[i] < nums[index]) {
            swap(nums, i, index);
            down(nums, index, length);
        }
    }

    /**215
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest1(int[] nums, int k) {
        findKthLargest(nums, nums.length - k, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    private void findKthLargest(int[] nums, int k, int left, int right) {
        if (left >= right) {
            return;
        }
        int highIndex = left;
        int highVal = nums[highIndex];
        int p = left;
        int q = right;
        while (left < right) {
            while (left < right && nums[right] > highVal) {
                right--;
            }
            while (left < right && nums[left] <= highVal) {
                left++;
            }
            swap(nums, left, right);
        }
        swap(nums, left, highIndex);
        if (left == k) {
            return;
        }
        if (left > k) {
            findKthLargest(nums, k, p, left - 1);
        } else {
            findKthLargest(nums, k, left + 1, q);
        }
    }

    /**215
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        for (int i = nums.length / 2; i >= 0; i--) {
            down(nums, i, nums.length);
        }
        for (int i = nums.length - 1; i > 0; i--,k--) {
            if (k == 1) {
                return nums[0];
            }
            swap(nums, 0, i);
            down(nums, 0, i);
        }
        return nums[0];
    }

    /**347
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {

        return null;
    }

}
