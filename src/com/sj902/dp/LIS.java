package com.sj902.dp;

import java.util.Arrays;
import java.util.TreeMap;

public class LIS {
    public int lengthOfLIS(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <i ; j++) {
                if(nums[j]<nums[i]){
                    res[i] = Math.max(res[j]+1, res[i]);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans= Math.max(ans, res[i]);
        }
        return ans;
    }
}