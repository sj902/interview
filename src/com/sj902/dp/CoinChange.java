package com.sj902.dp;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[][] res = new int[coins.length + 1][amount + 1];
        for (int i = 0; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j == 0) {
                    res[i][j] = 0;
                } else if (i == 0) {
                    res[i][j] = Integer.MAX_VALUE;
                } else {
                    if (j >= coins[i - 1] && res[i][j - coins[i - 1]] != Integer.MAX_VALUE) {
                        res[i][j] = Math.min(res[i - 1][j], 1 + res[i][j - coins[i - 1]]);
                    } else {
                        res[i][j] = res[i - 1][j];
                    }
                }
            }
        }
        return res[coins.length][amount] == Integer.MAX_VALUE ? -1 : res[coins.length][amount];
    }
}
