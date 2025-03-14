package com.sj0902.dp;

public class CoinChange {
    int[] c;
    Integer[][] dp;

    public int coinChange(int[] coins, int amount) {
        c = coins;
        dp = new Integer[coins.length][amount + 1];

        return aux(0, amount);
    }

    private int aux(int idx, int amount) {
        if (amount == 0) return 0;
        if (amount < 0 || idx >= c.length) return -1;
        if (dp[idx][amount] != null) return dp[idx][amount];
        int include = aux(idx, amount - c[idx]);
        int exclude = aux(idx + 1, amount);
        if (include == -1) {
            return dp[idx][amount] = exclude;
        }
        if (exclude == -1) {
            return dp[idx][amount] = include + 1;
        }
        return dp[idx][amount] = Math.min(include + 1, exclude);
    }

}
