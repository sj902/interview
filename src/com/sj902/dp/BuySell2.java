package com.sj902.dp;

public class BuySell2 {
    public int maxProfit(int[] prices) {
        int res = 0;
        int ans = 0;
        boolean bought = false;
        for (int i = 0; i < prices.length; i++) {
            if ((i == 0 || prices[i - 1] > prices[i]) && (i == prices.length - 1 || prices[i + 1] > prices[i])) {// isLocalMinima
                System.out.println("MInima::" + i);
                res = res - prices[i];
                bought = true;
            } else if (bought && (i == 0 || prices[i - 1] < prices[i]) && (i == prices.length - 1 || prices[i + 1] < prices[i])) { //is Local Maxima
                System.out.println("Maxima::" + i);
                res = res + prices[i];
            }
            ans = Math.max(ans, res);
        }
        return ans;
    }

}
