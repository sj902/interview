package com.sj902.arrays;

public class MaxSubArray {
    public int maxSubArray(final int[] arr) {
        int n = arr.length;
        int curr = 0;
        int sum = 0;
        int res = 0;
        int r = 0;
        while(r<n){
            curr = curr + arr[r];
            if(curr <=0){
                r = r+1;
                curr = 0;
            } else {
                res = Math.max(res, curr);
            }
        }

        return res;
    }
}
