package com.sj902.dp;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int s = nums[i] + nums[j] + nums[k];
                if (s == target) return s;
                if(Math.abs(s-target)<res) res = Math.abs(s-target);
                if(s<target)++j;
                else --k;
            }
        }
        return res;
    }
}
