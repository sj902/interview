package com.sj902.dp;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[amount + 1][coins.length + 1];
        for (int i = 0; i <= amount; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i <= amount; i++) {
            for (int j = coins.length - 1; j >= 0; j--) {
                if (i == 0) {
                    dp[i][j] = 0;
                } else {
                    if (i - coins[j] >= 0) {
                        int take = 0;
                        int k = dp[i - coins[j]][j];
                        if (k == Integer.MAX_VALUE) {
                            take = Integer.MAX_VALUE;
                        } else {
                            take = k + 1;
                        }
                        dp[i][j] = take;

                    }
                    dp[i][j] = Math.min(dp[i][j], dp[i][j + 1]);
                }
            }
        }

        if (dp[amount][0] == Integer.MAX_VALUE) return -1;
        return dp[amount][0];
    }
}
