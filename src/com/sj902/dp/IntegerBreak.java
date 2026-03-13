package com.sj902.dp;

public class IntegerBreak {
    public int integerBreak(int n) {
        int[] res = new int[n+1];
        res[0] = 0;
        res[1] = 1;
        res[2] = 1;
        for (int i = 3; i <=n ; i++) {
            res[i] = 0;
            for (int j = 1; j < i; j++) {
                int a= Math.max(j, res[j]);
                int b = Math.min(i-j, res[i-j]);
                res[i] = Math.max(res[i], a*b);
            }
        }
        return res[n];
    }
}
