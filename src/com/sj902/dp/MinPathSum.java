package com.sj902.dp;

public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int[] res = new int[grid[0].length];
        int m = grid.length;
        int n = grid[0].length;
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (x == 0 && y == 0) {
                    res[y] = grid[0][0];
                } else {
                    int left = Integer.MAX_VALUE;
                    if (x - 1 >= 0) {
                        left = grid[x][y] + res[y];
                    }
                    int up = Integer.MAX_VALUE;
                    if (y - 1 >= 0) {
                        up = grid[x][y] + res[y - 1];
                    }
                    res[y] = Math.min(up, left);
                }
            }
        }
        return res[n - 1];
    }
}
