package pers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void calcEquation() {
        List<List<String>> c = new ArrayList<>();
        List<String> o1 = new ArrayList<>();
        o1.add("a");
        o1.add("b");
        List<String> o2 = new ArrayList<>();
        o2.add("b");
        o2.add("c");
        c.add(o1);
        c.add(o2);
        double[] va = {2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        List<String> q1 = new ArrayList<>();
        q1.add("x");
        q1.add("x");
        List<String> q2 = new ArrayList<>();
        q2.add("b");
        q2.add("a");
        List<String> q3 = new ArrayList<>();
        q3.add("a");
        q3.add("e");
        queries.add(q1);
        queries.add(q2);
        queries.add(q3);

        Dfs dfs = new Dfs();
        dfs.calcEquation(c, va, queries);
    }

}