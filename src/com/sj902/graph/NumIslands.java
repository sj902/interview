package com.sj902.graph;

public class NumIslands {

    int[][] dirs;
    int res = 0;

    public int numIslands(char[][] grid) {
        dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != '0') {
                    dfs(i, j, grid);
                    ++res;
                }
            }
        }
        return res;
    }

    private void dfs(int i, int j, char[][] grid) {
        grid[i][j] = '0';
        for (int[] dir : dirs) {
            int newR = i + dir[0];
            int newC = j + dir[1];
            if (newR >= 0 && newC >= 0 && newR < grid.length && newC < grid[0].length && grid[newR][newC] == '1') {
                dfs(newR, newC, grid);
            }
        }
    }
}
