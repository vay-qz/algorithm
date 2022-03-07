package pers;

/**前缀和
 * @author qiaozhe
 * @date 2022/3/6
 */
public class PrefixSum {
    /**238
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        int[] res = new int[nums.length];
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = left[i] * right;
            if (i < nums.length - 1) {
                right *= nums[i + 1];
            }
        }
        return res;
    }
}
