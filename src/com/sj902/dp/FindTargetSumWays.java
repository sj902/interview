package com.sj902.dp;

public class FindTargetSumWays {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int a : nums) sum += a;
        int t = (sum - target) * 2;
        if (t > sum || t < 0) return 0;
        return aux(nums, t, 0);
    }

    int aux(int[] nums, int target, int idx) {
        if (target == 0  && idx == nums.length) return 1;
        if (idx >= nums.length || target < 0) return 0;
        return aux(nums, target, idx + 1) + aux(nums, target - nums[idx], idx + 1);
    }
}
