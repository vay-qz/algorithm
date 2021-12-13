package pers;

import java.util.*;

/**
 * @author qiaozhe
 * @date 2021/12/11
 */
public class Bfs {
    /**1091
     * @param grid
     * @return
     */
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0) {
            return -1;
        }
        int[] x = {1,1,0,-1,-1,-1,0,1};
        int[] y = {0,-1,-1,-1,0,1,1,1};
        boolean[][] visited = new boolean[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            visited[i] = new boolean[grid[0].length];
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        int time = 1;
        while (!queue.isEmpty()) {
            Stack<int[]> temp = new Stack<>();
            while (!queue.isEmpty()) {
                temp.push(queue.poll());
            }
            while (!temp.isEmpty()) {
                int[] node = temp.pop();
                if (node[0] == grid.length - 1 && node[1] == grid[0].length - 1) {
                    return time;
                }
                for (int i = 0; i < 8; i++) {
                    if ((node[0] + x[i] >= 0 && node[0] + x[i] < grid.length) &&
                            (node[1] + y[i] >= 0 && node[1] + y[i] < grid[0].length) &&
                            visited[node[0] + x[i]][node[1] + y[i]] == false &&
                            grid[node[0] + x[i]][node[1] + y[i]] == 0) {
                        queue.add(new int[]{node[0] + x[i], node[1] + y[i]});
                        visited[node[0] + x[i]][node[1] + y[i]] = true;
                    }
                }
            }
            time++;
        }
        return -1;
    }

    /**279
     * @param n
     * @return
     */
    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.add(n);
        set.add(n);
        int time = 0;
        while (!queue.isEmpty()) {
            time++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int t = queue.poll();
                for (int j = 1; j * j <= t; j++) {
                    if (j * j == t) {
                        return time;
                    }
                    if (!set.contains(t - j * j)) {
                        set.add(t - j * j);
                        queue.add(t - j * j);
                    }
                }
            }
        }
        return -1;
    }

    /**127
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> str = new LinkedList<>();
        Set<String> set = new HashSet<>();
        str.add(beginWord);
        int time = 1;
        while (!str.isEmpty()) {
            int len = str.size();
            for (int i = 0; i < len; i++) {
                String source = str.poll();
                if (source.equals(endWord)) {
                    return time;
                }
                for (String word : wordList) {
                    if (!set.contains(word) && diff(word, source) == 1) {
                        set.add(word);
                        str.add(word);
                    }
                }
            }
            time++;
        }
        return 0;
    }

    private int diff(String word, String source) {
        int res = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != source.charAt(i)) {
                res++;
            }
        }
        return res;
    }

}
