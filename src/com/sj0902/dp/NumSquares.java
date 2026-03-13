package com.sj0902.dp;

import java.util.Arrays;

public class NumSquares {
    int target;
    int[] sq;
    Integer dp[][];

    public int numSquares(int n) {
        sq = new int[100];
        for (int i = 1; i < 101; i++) {
            sq[i - 1] = i * i;
        }        target = n;

        dp = new Integer[n + 1][100];
        System.out.println(Arrays.toString(sq));
        if (n == 0) return 0;
        return aux(n, 0);
    }

    private int aux(int n, int index) {
        if (n < 0 || index >= 100) return target;
        if (n == 0) return 0;
        if (dp[n][index] != null) return dp[n][index];
        return dp[n][index] = Math.min(1 + aux(n - sq[index], index), aux(n, index + 1));
    }
}
