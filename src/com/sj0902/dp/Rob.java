package com.sj0902.dp;

public class Rob {
    int[] arr;

    public int rob(int[] nums) {
        arr = nums;
        return aux(0);
    }

    private int aux(int idx) {
        if (idx >= arr.length) return 0;
        return Math.max(arr[idx] + aux(idx + 2), aux(idx + 1));
    }
}
