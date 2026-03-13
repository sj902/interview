package com.sj902.graph;

public class MaxAreaOfIsalnds {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    int area = dfs(visited, grid, i, j);
                    res = Math.max(area, res);
                }
            }
        }
        return res;
    }


    public int dfs(boolean[][] visited, int[][] grid, int i, int j) {
        visited[i][j] = true;
        int m = grid.length;
        int n = grid[0].length;
        int size = 1;
        int[] a = new int[]{1, -1, 0, 0};
        int[] b = new int[]{0, 0, 1, -1};

        for (int q = 0; q < 4; ++q) {
            int k = i + a[q];
            int l = j + b[q];
            if (k < m && k >= 0 && l < n && l >= 0 && grid[k][l] == 1 && !visited[k][l]) {
                size = size + dfs(visited, grid, k, l);
            }
        }
        return size;
    }
}
