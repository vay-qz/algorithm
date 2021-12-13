package pers;

import java.util.Stack;

/**
 * @author qiaozhe
 * @date 2021/12/13
 */
public class Dfs {
    public int numIslands(char[][] grid) {
        int[] xx = {1, 0, -1, 0};
        int[] yy = {0, -1, 0, 1};
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    Stack<int[]> stack = new Stack<>();
                    stack.push(new int[]{i,j});
                    res++;
                    while (!stack.isEmpty()) {
                        int[] node = stack.pop();
                        grid[node[0]][node[1]] = '0';
                        for (int k = 0; k < 4; k++) {
                            int x = node[0] + xx[k];
                            int y = node[1] + yy[k];
                            if (x >= 0 && x < grid.length &&
                                    y >= 0 && y < grid[0].length &&
                                    grid[x][y] == '1') {
                                stack.push(new int[]{x, y});
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
