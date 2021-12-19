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

}