package com.sj0902.dp;

public class FindPaths {
    int m, n;
    int mod;
    Integer[][][] dp;

    public int findPaths(int a, int b, int maxMove, int startRow, int startColumn) {
        mod = 1000000007;
        m = a;
        n = b;
        dp = new Integer[m + 1][n + 1][maxMove + 1];
        return aux(startRow, startColumn, maxMove) % mod;
    }

    int aux(int startRow, int startColumn, int maxMove) {
        if (maxMove < 0) return 0;
        if ((startRow < 0 || startRow >= m))
            return 1;
        if ((startColumn < 0 || startColumn >= n))
            return 1;

        if (dp[startRow][startRow][maxMove] != null) return dp[startRow][startRow][maxMove];

        int a = 0, b = 0, c = 0, d = 0;

        a = aux(startRow + 1, startColumn, maxMove - 1) % mod;
        b = aux(startRow - 1, startColumn, maxMove - 1) % mod;
        c = aux(startRow, startColumn + 1, maxMove - 1) % mod;
        d = aux(startRow, startColumn - 1, maxMove - 1) % mod;
        return dp[startRow][startRow][maxMove] = (a + b + c + d) % mod;
    }
}
