package com.sj902.dp;

import java.util.Arrays;

public class UniquePaths {
    int[][] res;

    public int uniquePaths(int m, int n) {
        res = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(res[i], -1);
        }
        return uniquePathsAux(m - 1, n - 1, 0, 0);
    }

    private int uniquePathsAux(int maxRow, int maxCol, int i, int j) {
        if (i == maxRow && j == maxCol) return 1;
        if (i < 0 || j < 0 || j > maxCol || i > maxRow) return 0;
        if (res[i][j] != 1) return res[i][j];
        return res[i][j] = uniquePathsAux(maxRow, maxCol, i + 1, j) + uniquePathsAux(maxRow, maxCol, i, j + 1);
    }
}
