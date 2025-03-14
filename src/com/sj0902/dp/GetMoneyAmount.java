package com.sj0902.dp;

public class GetMoneyAmount {

    public int getMoneyAmount(int n) {
        return aux(1, n);
    }

    private int aux(int l, int r) {
        if(l>=r) return 0;
        int res = Integer.MAX_VALUE;
        for (int i = l; i <= r ; i++) {
            int c = i+ Math.max(aux(l, i-1), aux(i+1,r));
            res=Math.min(res, c);
        }
        return res;
    }
}
