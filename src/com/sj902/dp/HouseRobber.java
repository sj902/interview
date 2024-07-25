package com.sj902.dp;

public class HouseRobber {
    int[] res;

    public int rob(int[] nums) {
        int n = nums.length;
        res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            res[i] = -1;
        }
        return res[0] = nums[0];
    }

    public int robAux(int[] nums, int i) {
        if (i < 0) return Integer.MIN_VALUE;
        if (res[i] != 1) return res[i];
        return Math.max(robAux(nums, i - 1), robAux(nums, i - 2) + nums[i]);
    }
}
