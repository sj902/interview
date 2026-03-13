package com.sj0902.dp;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int curr = 0;
        for (int i = 0; i < nums.length; i++) {
            curr = curr + nums[i];
            res = Math.max(curr, res);
            if(curr<0){
                curr = 0;
            }
        }
        return res;
    }
}
