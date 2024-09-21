package com.sj902.dp;

public class HouseRobber {

    public int rob(int[] nums) {
        Integer[] res = new Integer[nums.length + 1];
        res[0] = 0;
        res[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res[i+1] = Math.max(res[i] , res[i-1]+nums[i]);
        }
        return res[nums.length];
    }
}
