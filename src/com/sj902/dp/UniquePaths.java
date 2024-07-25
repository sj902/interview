package com.sj902.dp;

import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {
    }

    int[][] res;

    public int uniquePaths(int m, int n) {
        res = new int[m + 1][n + 1];
        for (int i = 0; i <= m; ++i) {
            Arrays.fill(res[i], -1);

        }

        return uniquePathsAux(m, n);
    }

    public int uniquePathsAux(int m, int n) {
        if (m < 1 || n < 1) return 0;
        if (m == 1 && n == 1) return 1;
        if (res[m][n] != -1) return res[m][n];
        return res[m][n] = uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }
}
