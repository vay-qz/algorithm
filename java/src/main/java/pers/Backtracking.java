package pers;

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

    }
}
