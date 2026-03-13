package com.sj902.bitwise;

public class CountBits {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        int j = 1;
        for (int i = 2; i < n; ++i) {
            if (j * 2 == i)
                j = i;
            dp[i] = dp[i-j]+1;
        }
        return dp;
    }
}
