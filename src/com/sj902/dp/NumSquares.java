package com.sj902.dp;

public class NumSquares {
    int max;
    Integer[][] res;

    public int numSquares(int n) {
        max = (int) Math.floor(Math.sqrt(n));
        res = new Integer[max + 1][n + 1];
        return aux(1, n);
    }

    int aux(int idx, int n) {
        if (n == 0) return 0;
        if (n < 0) return 100000;
        if (idx > max) return 100000;
        if (res[idx][n] != null) return res[idx][n];
        int include = 1 + aux(idx, n - (idx * idx));
        int exclude = aux(idx + 1, n);
        return res[idx][n] = Math.min(exclude, include);
    }

}
