package com.sj902.dp;

public class HouseRobber2 {
    Integer[][] res;

    public int rob(int[] nums) {
        res = new Integer[2][nums.length];
        return Math.max(robAux(nums, 1, nums.length - 1), robAux(nums, 0, nums.length - 2));
    }

    private int robAux(int[] nums, int start, int idx) {
        if (idx >= nums.length - start) return 0;
        if (idx == start) return nums[idx];
        if (idx == start + 1) return Math.max(nums[idx], nums[idx-1]);
        if (res[start][idx] != null) return res[start][idx];
        return res[start][idx] = Math.max(nums[idx] + robAux(nums, start, idx - 2), robAux(nums, start, idx - 1));
    }
}