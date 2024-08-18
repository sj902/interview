package com.sj902.dp;

import java.util.Arrays;

public class CoinChange2 {
    int[][] res1;
    public int change1(int amount, int[] coins) {
        res1 = new int[coins.length][amount+1];
        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(res1[i], -1);
        }
        return changeAux(coins, 0, amount);
    }

    private int changeAux(int[] coins, int idx, int amount) {
        if(amount == 0) return 1;
        if(amount<0 || idx>=coins.length) return 0;
        if(res1[idx][amount]!=-1) return res1[idx][amount];
        int taken = changeAux(coins, idx, amount-coins[idx]);
        int notTaken = changeAux(coins, idx+1, amount);
        return res1[idx][amount]=taken+notTaken;
    }

    public int change(int amount, int[] coins) {
        int[][] res = new int[coins.length+1][amount+1];
        for (int i = 0; i <= coins.length; i++) {
            for (int j = 0; j <=amount ; j++) {
                if(j == 0){
                    res[i][j] = 1;
                } else if(i == 0) {
                    res[i][j] = 0;
                } else {
                    if (j>=coins[i-1]){
                        res[i][j] = res[i-1][j]+ res[i][j-coins[i-1]];
                    } else {
                        res[i][j] =res[i-1][j];
                    }
                }
            }
        }
        return res[coins.length][amount];
    }
}
