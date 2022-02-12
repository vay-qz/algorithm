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




}
