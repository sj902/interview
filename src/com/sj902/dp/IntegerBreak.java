package com.sj902.dp;

public class IntegerBreak {
    Integer[] res;
    public int integerBreak(int n) {
        res = new Integer[n];
        if (n == 0) return 0;
        if (n == 1) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;
        return aux(n);
    }

    private int aux(int n) {
        if(res[n]!=null) return res[n];
        int r = 1;
        for (int i = 1; i < n; i++) {
            int current = aux(i) * aux(n - i);
            r = Math.max(r, current);
        }

        return res[n]=Math.max(r, n);
    }
}
