package com.sj902.dp;

public class MinPathSum {
    Integer[][] res;

    public int minPathSum(int[][] grid) {
        res = new Integer[grid.length][grid[0].length];
        return minPathSumAux(grid, 0, 0);
    }

    private int minPathSumAux(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i == m - 1 && j == n - 1) return grid[i][j];
        if (i > m - 1 || j > n - 1) return Integer.MAX_VALUE;
        if (res[i][j] != null) return grid[i][j];
        int a = minPathSumAux(grid, i + 1, j);
        int b = minPathSumAux(grid, i, j + 1);
        if (a == b && b == Integer.MAX_VALUE) return res[i][j] = Integer.MAX_VALUE;
        return res[i][j]  = grid[i][j] + Math.min(a, b);
    }

}
