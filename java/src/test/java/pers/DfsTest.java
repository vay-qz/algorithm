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
}