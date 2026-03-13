package com.sj0902.buySellStock;

public class B1 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int min = prices[0];

        int res = 0;

        for (int i = 1; i < n; i++) {
            int curr = prices[i];
            if(curr>min){
                res = Math.max(res, curr-min);
            } else {
                min = curr;
            }
        }
        return res;
    }
}
