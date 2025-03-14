package com.sj0902.dp;

public class CombinationSum4 {
    int[] arr;

    public int combinationSum4(int[] nums, int target) {
        arr = nums;
        return aux(0, target);
    }

    private int aux(int idx, int target) {
        if (target < 0) return 0;
        if (idx == arr.length && target == 0) return 1;
        if (idx == arr.length) return 0;
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            k = k + aux(i, target - arr[i]);
        }
        return k;
    }
}
