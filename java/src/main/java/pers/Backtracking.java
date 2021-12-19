package pers;

import pers.struct.TreeNode;

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
            String re = "";
            for (String sa : r) {
                re += sa + ".";
            }
            if (re.length() == s.length() + 4) {
                res.add(re.substring(0, re.length() - 1));
            }
            return;
        }
        for (int i = index + 1; i <= s.length() && i < index + 4; i++) {
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
            r.remove(r.size() - 1);
        }
    }

    public boolean exist(char[][] board, String word) {
        boolean[][] visited;
        int[] xx = {1, 0, -1, 0};
        int[] yy = {0, -1, 0, 1};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited = new boolean[board.length][board[0].length];
                    visited[i][j] = true;
                    boolean res = exist(board, i, j, word, 1, visited, xx, yy);
                    if (res) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int i, int j, String word, int i1, boolean[][] visited, int[] xx, int[] yy) {
        if (i1 == word.length()) {
            return true;
        }
        char c = word.charAt(i1);
        for (int k = 0; k < 4; k++) {
            int x = i + xx[k];
            int y = j + yy[k];
            if (x >= 0 && x < board.length &&
                    y >= 0 && y < board[i].length &&
                    board[x][y] == c &&
                    !visited[x][y]) {
                visited[x][y] = true;
                boolean exist = exist(board, x, y, word, i1 + 1, visited, xx, yy);
                if (exist) {
                    return true;
                }
                visited[x][y] = false;
            }
        }
        return false;
    }

    public List<String> binaryTreePaths(TreeNode root) {

    }

}
