package com.sj902.dp;

public class MinPathSum {
    Integer[][] res;
    public int minPathSum(int[][] grid) {
        res = new Integer[grid.length][grid[0].length];
        return minPathSumAux(grid, 0, 0);
    }

    private int minPathSumAux(int[][] grid, int i, int j) {
        int m = grid.length - 1;
        int n = grid[0].length - 1;
        if(i ==m && j == n) return grid[i][j];
        if(i>m || j >n) return Integer.MAX_VALUE;
        if(res[i][j]!=null) return res[i][j];
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        if(i+1<=m) a = minPathSumAux(grid, i+1, j);
        if(j+1<=n) b = minPathSumAux(grid, i, j+1);
        return res[i][j]=Math.min(a,b)+grid[i][j];
    }
}
