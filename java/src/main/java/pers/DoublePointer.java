package pers;

import java.util.*;

/**
 * @author qiaozhe
 * @date 2022/2/9
 */
public class DoublePointer {

    /**167 两数之和
     * @param numbers
     * @param target
     * @return
     */
    int mid;
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (midFind(i + 1, numbers.length - 1, numbers, target - numbers[i])) {
                return new int[]{i, mid};
            }
        }
        return null;
    }

    private boolean midFind(int left, int right, int[] numbers, int target) {
        if (left >= right) {
            return false;
        }
        int mid = (left + right) / 2;
        if (numbers[mid] == target) {
            this.mid = mid;
            return true;
        } else if (numbers[mid] < target) {
            return midFind(mid + 1, right, numbers, target);
        } else {
            return midFind(left, mid - 1, numbers, target);
        }
    }

    /**633
     * @param c
     * @return
     */
    public boolean judgeSquareSum(int c) {
        long a = 0;
        long b = (int) Math.sqrt(c);
        while (a != b) {
            long t = a * a + b * b;
            if (t == c) {
                return true;
            } else if (t < c) {
                a++;
            } else {
                b--;
            }
        }
        return false;
    }

    public String reverseVowels(String s) {
        LinkedList<Character> chars = new LinkedList();
        Stack<Character> stack = new Stack();
        Set<Character> yuan = new HashSet();
        yuan.add('a');
        yuan.add('e');
        yuan.add('i');
        yuan.add('o');
        yuan.add('u');
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            while (!yuan.contains(s.charAt(i)) && i < j) {
                i++;
            }
            while (!yuan.contains(s.charAt(j)) && i < j) {
                j--;
            }
            if (i != j) {
                chars.add(s.charAt(j--));
                stack.push(s.charAt(i++));
            }
        }
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (yuan.contains(c)) {
                if (!chars.isEmpty()) {
                    builder.append(chars.removeFirst());
                } else {
                    builder.append(stack.pop());
                }
            }
        }
        return builder.toString();
    }

    /**524
     * @param s
     * @param dictionary
     * @return
     */
    public String findLongestWord(String s, List<String> dictionary) {
        dictionary.sort((a, b) -> {
            if (a.length() == b.length()) {
                for (int i = 0; i < a.length(); i++) {
                    if (a.charAt(i) != b.charAt(i)) {
                        return a.charAt(i) - b.charAt(i);
                    }
                }
                return 0;
            }
            return b.length() - a.length();
        });
        for (String c : dictionary) {
            if (isSub(s, c)) {
                return c;
            }
        }
        return "";
    }

    private boolean isSub(String s, String c) {
        int si = 0;
        for (int i = 0; i < c.length(); i++) {
            while (si < s.length() && s.charAt(i) != c.charAt(i)) {
                si++;
            }
            if (si == s.length()) {
                return false;
            }
            si++;
        }
        return true;
    }

    /**31
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int index = nums.length - 2;
        while (index >= 0 && nums[index] >= nums[index + 1]) {
            index--;
        }
        if (index >= 0) {
            int index2 = nums.length - 1;
            while (index2 > index && nums[index2] <= nums[index]) {
                index2--;
            }
            swap(nums, index, index2);
        }
        reverse(nums, index + 1);
    }

    private void reverse(int[] nums, int i) {
        int end = nums.length - 1;
        while (i > end) {
            swap(nums, i, end);
        }
    }

    private void swap(int[] nums, int index, int index2) {
        int temp = nums[index];
        nums[index] = nums[index2];
        nums[index2] = temp;
    }


    /**42 接雨水
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (height.length == 1) {
            return 0;
        }
        int left = 0;
        while (left < height.length && height[left] <= 0) {
            left++;
        }
        int right = height.length - 1;
        while (right >= 0 && height[right] <= 0) {
            right--;
        }
        int sum = 0;
        int leftMax = height[left];
        int rightMax = height[right];
        while (left < right) {
            int temp;
            while (left + 1 <= right && height[left + 1] >= leftMax) {
                left++;
                leftMax = height[left];
            }
            while (right - 1 >= left && height[right - 1] >= rightMax) {
                right--;
                rightMax = height[right];
            }
            if (left < right) {
                if (leftMax < rightMax) {
                    temp = leftMax - height[left + 1];
                    left++;
                } else {
                    temp = rightMax - height[right - 1];
                    right--;
                }
                sum += temp;
            }
        }
        return sum;
    }

}
