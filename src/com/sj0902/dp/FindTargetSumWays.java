package com.sj0902.dp;

public class FindTargetSumWays {
    int[] arr;

    public int findTargetSumWays(int[] nums, int target) {
        arr = nums;
        return aux(0, target);
    }

    private int aux(int idx, int target) {
        if (idx == arr.length && target == 0) return 1;
        if (idx == arr.length) return 0;
        int minus = aux(idx + 1, target - arr[idx]);
        int plus = aux(idx + 1, target + arr[idx]);
        return minus + plus;
    }
}
