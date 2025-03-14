package com.sj0902.dp;

public class BurstBalloons {
    int[] arr;

    public int maxCoins(int[] nums) {
        arr = nums;
        return aux(0, nums.length - 1);
    }

    private int aux(int l, int r) {
        if (l > r) {
            return 0;
        }
        int res = Integer.MIN_VALUE;
        for (int i = l; i <= r; i++) {
            int c = aux(l, i - 1) + aux(i + 1, r) + (get(i)*get(r+1)*get(l-1));
            res = Math.max(c, res);
        }
        return res;
    }

    private int get(int i) {
        if (i < 0 || i >= arr.length) return 1;
        return arr[i];
    }
}
