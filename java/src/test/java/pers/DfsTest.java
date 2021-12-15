package pers;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author qiaozhe
 * @date 2021/12/13
 */
public class DfsTest {

    @Test
    public void numIslands() {
        Dfs dfs = new Dfs();
        char[][] s = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        dfs.numIslands(s);
    }

    @Test
    public void solve() {
        Dfs dfs = new Dfs();
        char[][] s = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        dfs.solve(s);
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[0].length; j++) {
                System.out.print(s[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void pacificAtlantic() {
        Dfs dfs = new Dfs();
        int[][] s = {
                {1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4}
        };
        dfs.pacificAtlantic(s);
        int[][] s2 = {
                {1,1},
                {1,1},
                {1,1}
        };
        dfs.pacificAtlantic(s2);
        int[][] s3 = {
                {3,3,3,3,3,3},
                {3,0,3,3,0,3},
                {3,3,3,3,3,3}
        };
        dfs.pacificAtlantic(s3);
    }

}