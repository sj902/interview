package com.sj902.dp;

public class NumSquares {
    public int numSquares(int n) {
        Integer[] res = new Integer[n + 1];
        res[0] = 0;
        res[1] = 0;
        for (int i = 2; i <= n; i++) {
            int re = Integer.MAX_VALUE;
            for (int j = 1; j <= Math.sqrt(n); j++) {
                int k = res[i - (j * j)];
                if (k != Integer.MAX_VALUE) {
                    re = Math.min(re, k + 1);
                }
            }
        }
        return res[n];
    }
}
