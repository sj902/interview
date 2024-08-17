package com.sj902.dp;

public class MaxProduct {
    public int maxProduct(int[] nums) {
        double min = 1;
        double max = 1;
        double res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                min = 1;
                max = 1;
                res = Math.max(res, 0);
            } else {
                double t = max*nums[i];
                max = Math.max(max*nums[i], Math.max(min*nums[i], nums[i]));
                min = Math.min(max*nums[i], Math.min(min*nums[i], nums[i]));
                res = Math.max(res, max);
            }
        }
        return (int)res;
    }
}
