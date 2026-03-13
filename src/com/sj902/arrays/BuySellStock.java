package com.sj902.arrays;

public class BuySellStock {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int res = 0;
        int currMin = prices[0];
        int currMax = prices[0];
        for (int i = 1; i < n; ++i) {
            currMax = Math.max(prices[i], currMax);
            currMin = Math.min(prices[i], currMin);
            if (prices[i] == currMax) {
                res = Math.max(prices[i] - currMin, res);
            }
        }
        return res;
    }
}
