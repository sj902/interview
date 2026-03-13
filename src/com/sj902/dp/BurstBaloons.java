package com.sj902.dp;

public class BurstBaloons {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] b = new int[n + 2];
        int[][] dp = new int[n + 2][n + 2];
        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < n + 2; j++) {
                dp[i][j] = -1;
            }
        }
        b[0] = 1;
        b[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            b[i] = nums[i - 1];
        }

        for (int len = 0; len < n; len++) {
            for (int i = 1; i + len <= n; i++) {
                int j = i + len;
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.max(
                            dp[i][j],
                            dp[i][k - 1] + dp[k + 1][j] + (b[i-1] * b[k] * b[j+1])
                    );
                }
            }
        }
        return dp[0][n + 1];
    }
}
