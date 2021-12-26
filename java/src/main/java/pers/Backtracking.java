package pers;

import pers.struct.TreeNode;

import java.util.*;

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

    /**全排列
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        permute(res, nums, temp, visited);
        return res;
    }

    private void permute(List<List<Integer>> res, int[] nums, List<Integer> temp, boolean[] visited) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                temp.add(nums[i]);
                permute(res, nums, temp, visited);
                temp.remove(temp.size() - 1);
                visited[i] = false;
            }
        }
    }
    /**257
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        binaryTreePaths(res, root, temp);
        return res;
    }

    private void binaryTreePaths(List<String> res, TreeNode root, List<Integer> temp) {
        if (root.left == null && root.right == null) {
            String s = "";
            for (Integer t : temp) {
                s += t;
                s += "->";
            }
            s += root.val;
            res.add(s);
        }
        if (root.left != null) {
            temp.add(root.val);
            binaryTreePaths(res, root.left, temp);
            temp.remove(temp.size() - 1);
        }
        if (root.right != null) {
            temp.add(root.val);
            binaryTreePaths(res, root.right, temp);
            temp.remove(temp.size() - 1);
        }
    }

    /**77
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        combine(res, temp, 0, n, k);
        return res;
    }

    private void combine(List<List<Integer>> res, List<Integer> temp, int i, int n, int k) {
        if (temp.size() == k) {
            res.add(new ArrayList<>(temp));
        }
        for (int t = i + 1; t <= n; t++) {
            temp.add(t);
            combine(res, temp, t, n, k);
            temp.remove(temp.size() - 1);
        }
    }

    /**39
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(res, temp, 0, candidates, target, 0);
        return res;
    }

    private void combinationSum(List<List<Integer>> res, List<Integer> temp, int sum, int[] candidates, int target, int head) {
        if (sum == target) {
            res.add(new ArrayList<>(temp));
        }
        for (int i = head; i < candidates.length; i++) {
            if (sum + candidates[i] <= target) {
                temp.add(candidates[i]);
                combinationSum(res, temp, sum + candidates[i], candidates, target, i);
                temp.remove(temp.size() - 1);
            } else {
                break;
            }
        }
    }

    /**40
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        boolean[] visited = new boolean[candidates.length];
        combinationSum2(candidates, target, res, temp, 0, 0, visited);
        return res;
    }

    private void combinationSum2(int[] candidates, int target, List<List<Integer>> res, List<Integer> temp, int sum, int begin, boolean[] visited) {
        if (sum == target) {
            res.add(new ArrayList<>(temp));
        }
        for (int i = begin; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && !visited[i - 1]) {
                continue;
            }
            if (sum + candidates[i] <= target) {
                temp.add(candidates[i]);
                visited[i] = true;
                combinationSum2(candidates, target, res, temp, sum + candidates[i], i + 1, visited);
                temp.remove(temp.size() - 1);
                visited[i] = false;
            } else {
                break;
            }
        }
    }

    /**216
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        combinationSum3(res, temp, k, n, 0, 1);
        return res;
    }

    private void combinationSum3(List<List<Integer>> res, List<Integer> temp, int k, int n, int sum, int index) {
        if (sum == n) {
            if (temp.size() == k) {
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        if (temp.size() > k) {
            return;
        }
        for (int i = index; i < 10; i++) {
            temp.add(i);
            combinationSum3(res, temp, k, n, sum + i, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    /**78
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        subsets(res, temp, -1, nums);
        return res;
    }

    private void subsets(List<List<Integer>> res, List<Integer> temp, int i, int[] nums) {
        res.add(new ArrayList<>(temp));
        if (nums.length == i) {
            return;
        }
        for (int j = i + 1; j < nums.length; j++) {
            temp.add(nums[j]);
            subsets(res, temp, j, nums);
            temp.remove(temp.size() - 1);
        }
    }

    /**90
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        subsetsWithDup(res, temp, -1, nums, visited);
        return res;
    }

    private void subsetsWithDup(List<List<Integer>> res, List<Integer> temp, int i, int[] nums, boolean[] visited) {
        res.add(new ArrayList<>(temp));
        if (nums.length == i) {
            return;
        }
        for (int j = i + 1; j < nums.length; j++) {
            if (j > 0 && nums[j] == nums[j - 1] && !visited[j - 1]) {
                continue;
            }
            visited[j] = true;
            temp.add(nums[j]);
            subsetsWithDup(res, temp, j, nums, visited);
            temp.remove(temp.size() - 1);
            visited[j] = false;
        }
    }

    /**131
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        partition(res, temp, s, 0);
        return res;
    }

    private void partition(List<List<String>> res, List<String> temp, String s, int i) {
        if (i == s.length()) {
            res.add(new ArrayList<>(temp));
        }
        for (int j = i + 1; j <= s.length(); j++) {
            String substring = s.substring(i, j);
            if (isHw(substring)) {
                temp.add(substring);
                partition(res, temp, s, j);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isHw(String substring) {
        int head = 0;
        int tail = substring.length() - 1;
        while (true) {
            if (head >= tail) {
                break;
            }

            if (substring.charAt(head) != substring.charAt(tail)) {
                return false;
            }

            head++;
            tail--;
        }
        return true;
    }

    /**47
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        permuteUnique(res, nums, visited, temp);
        return res;
    }

    private void permuteUnique(List<List<Integer>> res, int[] nums, boolean[] visited, List<Integer> temp) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                    continue;
                }
                visited[i] = true;
                temp.add(nums[i]);
                permuteUnique(res, nums, visited, temp);
                temp.remove(temp.size() - 1);
                visited[i] = false;
            }
        }
    }

    /**37
     * @param board
     */
    public void solveSudoku(char[][] board) {
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    stack.push(new int[]{i, j});
                }
            }
        }
        solveSudoku(board, stack);
    }

    private boolean solveSudoku(char[][] board, Stack<int[]> stack) {
        if (stack.isEmpty()) {
            return true;
        }
        int[] pop = stack.pop();
        int x = pop[0];
        int y = pop[1];
        boolean[] selected = make(board, x, y);
        for (int i = 1; i < 10; i++) {
            if (!selected[i]) {
                board[x][y] = (char) ('0' + i);
                if (solveSudoku(board, stack)) {
                    return true;
                }
            }
        }
        board[x][y] = '.';
        stack.push(pop);
        return false;
    }

    private boolean[] make(char[][] board, int p, int q) {
        boolean[] res = new boolean[10];
        for (int i = 0; i < 9; i++) {
            if (board[i][q] != '.') {
                res[board[i][q] - '0'] = true;
            }
            if (board[p][i] != '.') {
                res[board[p][i] - '0'] = true;
            }
        }
        for (int i = (p / 3) * 3; i < (p / 3 + 1) * 3; i++) {
            for (int j = (q / 3) * 3; j < (q / 3 + 1) * 3; j++) {
                if (board[i][j] != '.') {
                    res[board[i][j] - '0'] = true;
                }
            }
        }
        return res;
    }


    /**51
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {

        return null;
    }

}
