package pers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author qiaozhe
 * @date 2021/12/17
 */
public class BacktrackingTest {
    Backtracking backtracking;

    @Before
    public void init() {
        backtracking = new Backtracking();
    }

    @Test
    public void letterCombinations() {
        backtracking.letterCombinations("23");
    }


    @Test
    public void restoreIpAddresses() {
        backtracking.restoreIpAddresses("25525511135");
    }

    @Test
    public void exist() {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        backtracking.exist(board, "ABCCED");
    }

    @Test
    public void combine() {
        backtracking.combine(4, 2);
    }

    @Test
    public void combinationSum() {
        int[] s = {2,7,6,3,5,1};
        backtracking.combinationSum(s, 9);
    }

    @Test
    public void partition() {
        backtracking.partition("aab");
    }

    @Test
    public void subsetsWithDup() {
        int[] s = {1,2,2};
        backtracking.subsetsWithDup(s);
    }

    @Test
    public void combinationSum2() {
        int[] s = {10,1,2,7,6,1,5};
        backtracking.combinationSum2(s, 8);
    }

    @Test
    public void combinationSum3() {
        backtracking.combinationSum3(3, 7);
    }

    @Test
    public void solveSudoku() {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'},
        };
        backtracking.solveSudoku(board);
    }
}