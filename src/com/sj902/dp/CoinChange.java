package com.sj902.dp;

public class CoinChange {

    public static void main(String[] args) {
    }

    int[][] res;

    public int coinChange(int[] coins, int amount) {
        res = new int[amount + 1][coins.length + 1];
        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j <= coins.length; j++) {
                res[i][j] = -1;
            }
        }
        int k = coinChangeAux(coins, amount, coins.length - 1);
        return k == Integer.MAX_VALUE ? -1 : k;
    }

    public int coinChangeAux(int[] coins, int amount, int i) {
        if (amount == 0) return 0;
        if (amount < 0 || i < 0) return Integer.MAX_VALUE - 1;
        if (res[amount][i] != - 1) return res[amount][i];

        if (i == 0) {
            int k = coinChangeAux(coins, amount - coins[i], i);
            if (k == Integer.MAX_VALUE - 1) return res[amount][i] = Integer.MAX_VALUE - 1;
            else return res[amount][i] = k + 1;
        }

        int a = coinChangeAux(coins, amount - coins[i], i);
        int b = coinChangeAux(coins, amount, i - 1);
        if (a != Integer.MAX_VALUE) {
            a++;
        }

        return res[amount][i] = Math.min(a, b);
    }
}
