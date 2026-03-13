package com.sj902.dp;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        int n = cost.length;
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(cost[i - 2] + dp[i - 2], cost[i - 1] + dp[i - 1]);
        }
        return dp[n - 1];
    }
}
