package com.sj902.dp;

public class TilingRectangle {
    Integer[][] dp;

    public int tilingRectangle(int n, int m) {
        dp = new Integer[n + 1][m + 1];
        return tilingRectangle1(n, m);
    }

    public int tilingRectangle1(int n, int m) {
        if (m <= 0 || n <= 0) return 0;
        if (dp[n][m] != null) return dp[n][m];
        int a = Math.min(n, m);
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= a; i++) {
            res = Math.min(
                    res,
                    1 + tilingRectangle1(n - i, m) + tilingRectangle1(n, m - i)
            );
        }
        return dp[n][m] = res;
    }
}
