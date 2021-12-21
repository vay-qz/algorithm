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
}