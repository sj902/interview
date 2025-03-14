package com.sj0902.sliding;

public class NumSubarraysWithSum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return aux(nums, goal) - aux(nums, goal - 1);
    }

    public int aux(int[] nums, int goal) {
        if (goal < 0) return 0;
        int l = 0;
        int r = 0;
        int res = 0;
        int sum = 0;
        while (r < nums.length) {
            int c = nums[r];
            sum = sum + c;
            ++r;
            while (sum > goal) {
                sum -= nums[l];
                ++l;
            }
            res += (r-l);
        }
        return res;
    }
}
