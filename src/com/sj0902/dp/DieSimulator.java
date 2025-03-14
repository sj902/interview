package com.sj0902.dp;

public class DieSimulator {
    int[] cons;
    Integer dp[][][];
    int mod;

    public int dieSimulator(int n, int[] rollMax) {
        mod = 1000000007;
        int max = 0;
        for (int i : rollMax) max = Math.max(i, max);
        dp = new Integer[n + 1][7][max];
        cons = rollMax;
        int res = 0;
        for (int i = 1; i <= 6; i++) {
            res = res + aux(n - 1, i, 1);
        }
        return res;
    }

    private int aux(int rolls, int last, int lastCount) {
        if (rolls == 0) return 1;
        if (dp[rolls][last][lastCount] != null) return dp[rolls][last][lastCount];
        int res = 0;
        for (int i = 1; i <= 6; i++) {
            if (i == last) {
                if (lastCount < cons[i - 1]) {
                    res = res + aux(rolls - 1, i, lastCount + 1);
                }
            } else {
                res = res + aux(rolls - 1, i, 1);
            }
        }
        return dp[rolls][last][lastCount] = res;
    }
}
