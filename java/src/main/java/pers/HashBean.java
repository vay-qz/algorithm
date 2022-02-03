package pers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author qiaozhe
 * @date 2022/2/3
 */
public class HashBean {

    /**1
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hash = new HashMap();
        HashMap<Integer, Integer> hash2 = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(nums[i])) {
                hash2.put(nums[i], i);
            } else {
                hash.put(nums[i], i);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if(target == nums[i] * 2) {
                if (hash.containsKey(nums[i]) && hash2.containsKey(nums[i])) {
                    int[] res = new int[2];
                    res[0] = hash.get(nums[i]);
                    res[1] = hash2.get(nums[i]);
                    return res;
                }
            }
            if (hash.get(target - nums[i]) != null) {
                int[] res = new int[2];
                res[0] = hash.get(nums[i]);
                res[1] = hash.get(target - nums[i]);
                return res;
            }
        }
        return null;
    }

    /**128
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet();
        for (int i : nums) {
            set.add(i);
        }
        int max = 1;
        for (Integer i : set) {
            int temp = 0;
            if (set.contains(i - 1)) {
                continue;
            }
            while (set.contains(i)) {
                temp++;
                i++;
            }
            if (max < temp) {
                max = temp;
            }
        }
        return max;
    }

}
