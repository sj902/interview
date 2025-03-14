package com.sj0902.buySellStock;

public class B3 {
    int[] arr;

    public int maxProfit(int[] prices) {
        arr = prices;
        return aux(0, 0);
    }

    private int aux(int idx, int state) {
        if (state >= 4) return 0;
        if (idx >= arr.length) return 0;
        switch (state) {
            case 0:
                return Math.max(aux(idx + 1, state), aux(idx + 1, state + 1) - arr[idx]);
            case 1:
                return Math.max(aux(idx + 1, state), aux(idx + 1, state + 1) + arr[idx]);
            case 2:
                return Math.max(aux(idx + 1, state), aux(idx + 1, state + 1) - arr[idx]);
            case 3:
                return Math.max(aux(idx + 1, state), aux(idx + 1, state + 1) + arr[idx]);
            default:
                return 0;
        }
    }
}
