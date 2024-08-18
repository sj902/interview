package com.sj902.dp;

public class HouseRobber {
    Integer[] res;

    public int rob(int[] nums) {
        res = new Integer[nums.length];
        return robAux(nums, nums.length-1);
    }

    private int robAux(int[] nums, int idx) {
        if (idx >= nums.length) return 0;
        if (idx == 0) return nums[idx];
        if (idx == 1) return Math.max(nums[idx], nums[idx] - 1);
        if (res[idx] != null) return res[idx];
        return res[idx] = Math.max(nums[idx] + robAux(nums, idx - 2), robAux(nums, idx - 1));
    }
}
