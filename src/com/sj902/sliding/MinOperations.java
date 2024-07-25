package com.sj902.sliding;

public class MinOperations {
    public int minOperations(int[] nums) {
        int res = 0;
        int min = Integer.MAX_VALUE;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            min = Math.min(min, nums[i]);
        }


        for (int i = 0; i < n; i++) {
            if(nums[i]-min>n)++res;
        }
        return res;
    }
}
