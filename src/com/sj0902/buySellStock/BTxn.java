package com.sj0902.buySellStock;

public class BTxn {
    int f;
    int[] arr;

    public int maxProfit(int[] prices, int fee) {
        arr = prices;
        f = fee;
        return aux(0, 0);
    }

    private int aux(int idx, int state) {
        if (idx >= arr.length) return 0;
        if (state == 0) {
            return Math.max(aux(idx + 1, 0), aux(idx + 1, 1) - arr[idx]);
        } else {
            return Math.max(aux(idx + 1, 0), aux(idx + 1, 1) + arr[idx]) + f;
        }
    }
}
