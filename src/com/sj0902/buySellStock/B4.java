package com.sj0902.buySellStock;

public class B4 {
    int[] arr;

    public int maxProfit(int k, int[] prices) {
        arr = prices;
        return aux(2 * k, 0);
    }

    private int aux(int k, int idx) {
        if (k <= 0) return 0;
        boolean buy = k % 2 == 0;
        if (idx >= arr.length) return 0;

        if (buy) {
            return Math.max(aux(k, idx + 1), aux(k - 1, idx + 1) - arr[idx]);
        } else {
            return Math.max(aux(k, idx + 1), aux(k - 1, idx + 1) + arr[idx]);
        }
    }
}
