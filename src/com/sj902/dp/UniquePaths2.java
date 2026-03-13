package com.sj902.dp;

import java.util.Arrays;

public class UniquePaths2 {
    int[][] res;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]==1) return 0;
        res = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length; i++) {
            Arrays.fill(res[i], -1);
        }
        return aux(obstacleGrid, 0, 0);
    }

    private int aux(int[][] obstacleGrid, int i, int j) {
        if(i == obstacleGrid.length-1 && j == obstacleGrid[0].length-1) return 1;
        if(i<0 || j <0 || i>=obstacleGrid.length || j>=obstacleGrid[0].length || obstacleGrid[i][j] == 1) return 0;
        if(res[i][j]!=-1) return res[i][j];
        return res[i][j] = aux(obstacleGrid, i+1, j) + aux(obstacleGrid, i, j+1);
    }
}
