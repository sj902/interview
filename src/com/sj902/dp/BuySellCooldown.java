package com.sj902.dp;

public class BuySellCooldown {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][3];
        for (int idx = n - 1; idx >= 0; idx--) {
            dp[idx][0] = Math.max(dp[idx + 1][2] - prices[idx], dp[idx + 1][0]);
            dp[idx][1] = dp[idx + 1][0];
            dp[idx][2] = Math.max(dp[idx + 1][1] + prices[idx], dp[idx + 1][2]);
        }
        return dp[0][0];
    }
}
