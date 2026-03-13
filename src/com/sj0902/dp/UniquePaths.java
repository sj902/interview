package com.sj0902.dp;

public class UniquePaths {
    int m;
    int n;

    public int uniquePaths(int i, int j) {
        m = i;
        n = j;
        return aux(0, 0);
    }

    private int aux(int i, int j) {
        if (i == m - 1 && j == n - 1) return 1;
        if (i >= m || j >= n) return 0;
        return aux(i + 1, j) + aux(j + 1, i);
    }
}
