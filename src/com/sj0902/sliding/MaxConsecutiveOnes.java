package com.sj0902.sliding;

public class MaxConsecutiveOnes {
    public int longestOnes(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int res = 0;
        int z = 0;
        while (r<nums.length){
            int c = nums[r];
            if(c == 0) {
                ++z;
            }
            ++r;
            while(z>k){
                int w = nums[l];
                if(w == 0){
                    --z;
                }
                ++l;
            }
            res = Math.max(res, r-l);
        }
        return res;
    }
}
