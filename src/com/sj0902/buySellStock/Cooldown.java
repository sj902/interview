package com.sj0902.buySellStock;

public class Cooldown {
    int[] arr;

    public int maxProfit(int[] prices) {
        arr = prices;
        return aux(0, true);
    }

    private int aux(int idx, boolean buy) {
        if (idx >= arr.length) return 0;
        if (buy) {
            return Math.max(
                    aux(idx + 1, true),
                    aux(idx + 1, false) - arr[idx]
            );
        } else {
            return Math.max(
                    aux(idx + 1, false),
                    aux(idx + 2, true) + arr[idx]
            );
        }
    }
}
