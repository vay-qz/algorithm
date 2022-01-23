package pers;

import java.util.HashMap;
import java.util.Map;

public class StringBean {

    /**242
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        int[] bucket = new int[26];
        for (char c : s.toCharArray()) {
            bucket[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            bucket[c - 'a']--;
            if (bucket[c - 'a'] < 0) {
                return false;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (bucket[i] > 0) {
                return false;
            }
        }
        return true;
    }

    /**409
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        int[] bucket = new int[58];
        for (char c : s.toCharArray()) {
            bucket[c - 'a']++;
        }
        int sum = 0;
        for (int i = 0; i < 58; i++) {
            sum += Integer.MAX_VALUE - 1 & bucket[i];
        }
        return sum == s.length() ? sum : sum + 1;
    }

    /**205
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> hash = new HashMap<>();
        Map<Character, Character> hash2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character character = hash.get(s.charAt(i));
            if (character == null) {
                hash.put(s.charAt(i), t.charAt(i));
            } else if (character != t.charAt(i)) {
                return false;
            }
            Character character2 = hash2.get(t.charAt(i));
            if (character2 == null) {
                hash2.put(t.charAt(i), s.charAt(i));
            } else if (character2 != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    /**647
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            int tempSum = 0;
            for (int j = 0; j <= i; j++) {
                String substring = s.substring(j, i + 1);
                if (isHW(substring)) {
                    tempSum++;
                }
            }
            dp[i] = dp[i - 1] + tempSum;
        }
        return dp[s.length() - 1];
    }

    private boolean isHW(String substring) {
        int head = 0, tail = substring.length() - 1;
        while (head <= tail) {
            if (substring.charAt(head) != substring.charAt(tail)) {
                return false;
            }
            head++;
            tail--;
        }
        return true;
    }

    /**9
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        String s = "" + x;
        return isHW(s);
    }

    /**696
     * @param s
     * @return
     */
    public int countBinarySubstrings(String s) {
        if (s.length() == 1) {
            return 0;
        }
        int[] t = new int[s.length()];
        int index = 0;
        int k = s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == k) {
                t[index]++;
            } else {
                k = s.charAt(i);
                index++;
                t[index] = 1;
            }
        }
        int sum = 0;
        for (int i = 1; i < t.length; i++) {
            if (t[i] == 0) {
                break;
            }
            sum += Math.min(t[i], t[i - 1]);
        }
        return sum;
    }

}
