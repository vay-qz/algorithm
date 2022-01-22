package pers;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

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
}
