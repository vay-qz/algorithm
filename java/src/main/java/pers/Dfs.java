package pers;

import java.util.Stack;

/**
 * @author qiaozhe
 * @date 2021/12/13
 */
public class Dfs {

    /**岛屿的最大面积 695
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        int[] xx = {1,0,-1,0};
        int[] yy = {0, -1,0,1};
        int max = 0;
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                stack.push(new int[]{i, j});
                int temp = 0;
                while (!stack.isEmpty()) {
                    int[] pop = stack.pop();
                    if (grid[pop[0]][pop[1]] == 0) {
                        continue;
                    }
                    grid[pop[0]][pop[1]] = 0;
                    for (int k = 0; k < 4; k++) {
                        if (pop[0] + xx[k] >= 0 && pop[0] + xx[k] < grid.length &&
                                pop[1] + yy[k] >= 0 && pop[1] + yy[k] <= grid[0].length) {
                            if (grid[pop[0] + xx[k]][pop[1] + yy[k]] == 1) {
                                stack.push(new int[]{pop[0] + xx[k], pop[1] + yy[k]});
                            }
                        }
                    }
                    temp++;
                }
                if (temp > max) {
                    max = temp;
                }
            }
        }
        return max;
    }

    /**200
     * @param grid
     * @return
     */
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

    /**130
     * @param board
     */
    public void solve(char[][] board) {
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                change(board, stack, i, 0);
            }
            if (board[i][board[0].length - 1] == 'O') {
                change(board, stack, i, board[0].length - 1);
            }
        }
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                change(board, stack, 0, i);
            }
            if (board[board.length - 1][i] == 'O') {
                change(board, stack, board.length - 1, i);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'y') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void change(char[][] board, Stack<int[]> stack, int i, int j) {
        int[] xx = {1, 0, -1, 0};
        int[] yy = {0, -1, 0, 1};
        stack.push(new int[]{i, j});
        while (!stack.isEmpty()) {
            int[] pop = stack.pop();
            int x = pop[0];
            int y = pop[1];
            board[x][y] = 'y';
            for (int k = 0; k < 4; k++) {
                if (x + xx[k] >= 0 && x + xx[k] < board.length &&
                        y + yy[k] >= 0 && y + yy[k] < board[0].length &&
                        board[x + xx[k]][y + yy[k]] == 'O') {
                    stack.push(new int[]{x + xx[k], y + yy[k]});
                }
            }
        }
    }


    /**547
     * @param isConnected
     * @return
     */
    public int findCircleNum(int[][] isConnected) {
        return 1;
    }
}
