package com.sj0902.dp;

public class MinScoreTriangulation {
    int[] arr;

    public int minScoreTriangulation(int[] values) {
        arr = values;
        return aux(0, arr.length - 1);
    }

    private int aux(int l, int r) {
        if (l + 1 == r) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int i = l + 1; i < r; i++) {
            int c = arr[i] * arr[l] * arr[r] + aux(l, i) + aux(i, r);
            res = Math.min(res, c);
        }
        return res;
    }
}
