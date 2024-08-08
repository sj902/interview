package com.sj902.arrays;

public class MaximumTotalCostAlt {
    public long maximumTotalCost(int[] nums) {
    int[] dp = new int[nums.length];
    int n = nums.length;
    int i = 1;
    dp[0] = nums[0];
    while (i<n){
        if(i<2) dp[i] = dp[i-1]+Math.abs(nums[i]);
        else {
            dp[i] = Math.max(dp[i-1]+(nums[i]), dp[i-2]+nums[i-1]+Math.abs(nums[i]));
        }
        ++i;
     }

    return dp[nums.length-1];
    }
}
