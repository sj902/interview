package com.sj902.arrays;

public class MaxSubArray {
    public int maxSubArray(final int[] arr) {
        int curr = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            curr = curr+arr[i];
            res = Math.max(curr, res);
            if(curr<0){
                curr = 0;
            }
        }
        return res;
    }
}
