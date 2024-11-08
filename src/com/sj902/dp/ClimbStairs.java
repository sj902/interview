package com.sj902.dp;

public class ClimbStairs {
    int[] res;

    public int climbStarisAux(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;

        System.out.println(n);
        if (res[n] != -1) return res[n];
        res[n] = climbStarisAux(n - 1) + climbStarisAux(n - 2);
        return res[n];
    }

    public int climbStairs(int n) {
        res = new int[n + 2];
        for (int i = 0; i <= n; i++) {
            res[i] = -1;
        }
        return climbStarisAux(n);
    }
}
