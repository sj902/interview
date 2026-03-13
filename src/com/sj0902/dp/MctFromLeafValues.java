package com.sj0902.dp;

public class MctFromLeafValues {
    int[] nums;
    Integer[][] dp;

    public int mctFromLeafValues(int[] arr) {
        dp = new Integer[arr.length + 1][arr.length + 1];
        nums = arr;
        return aux(0, arr.length - 1);
    }

    private int aux(int l, int r) {
        if (l == r) return 0;
        if (dp[l][r] != null) return dp[l][r];
        int res = Integer.MAX_VALUE;
        for (int i = l; i < r; i++) {
            int c = (getMax(l, i) * getMax(i + 1, r)) + aux(l, i) + aux(i + 1, r);
            res = Math.min(res, c);
        }
        return dp[l][r] = res;
    }

    private int getMax(int l, int r) {
        int res = nums[l];
        for (int i = l; i <= r; i++) {
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}
