package com.sj902.graph;

public class MinimumAreaToCover1s {
    public int minimumArea(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int maxX = -1;
        int maxY = -1;
        int minX = m;
        int minY = n;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    maxX = Math.max(i, maxX);
                    maxY = Math.max(j, maxY);
                    minX = Math.min(i, minX);
                    minY = Math.min(j, minY);
                }
            }
        }
        return (maxX-minX+1) * (maxY-minY+1);
    }
}
