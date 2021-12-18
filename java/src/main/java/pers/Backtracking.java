package pers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Backtracking {

    /**电话号码的所有组合
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        back(res, phoneMap, digits, 0, new StringBuilder());
        return res;
    }

    private void back(List<String> res, Map<Character, String> phoneMap, String digits, int i, StringBuilder builder) {
        if (builder.length() == digits.length()) {
            res.add(builder.toString());
            return;
        }
        char c = digits.charAt(i);
        String s = phoneMap.get(c);
        for (char cc : s.toCharArray()) {
            builder.append(cc);
            back(res, phoneMap, digits, i + 1, builder);
            builder.deleteCharAt(i);
        }
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        List<String> r = new ArrayList<>();
        restore(res, r, s, 0);
        return res;
    }

    private void restore(List<String> res, List<String> r, String s, int index) {
        if (r.size() == 4) {
            ArrayList<String> objects = new ArrayList<>();
            String re = "";
            for (String sa : objects) {
                re += sa;
            }
            res.add(re);
            return;
        }
        for (int i = index; i < s.length() && i < index + 3; i++) {
            String substr = s.substring(index, i);
            if (!"0".equals(substr) && substr.startsWith("0")) {
                return;
            }
            Integer in = Integer.parseInt(substr);
            if (in > 255) {
                return;
            }
            r.add(substr);
            restore(res, r, s, i);
            r.remove(i);
        }
    }

}
