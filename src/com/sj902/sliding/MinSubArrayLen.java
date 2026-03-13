package com.sj902.sliding;

public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int curr = 0;
        int i = 0;
        int j = 0;
        int res = nums.length;
        while (j < nums.length) {
            curr = curr + nums[j];
            ++j;
            if (curr >= target) {
                res = Math.min(res, j - i + 1);
            }
            while (curr >= target) {
                int q = nums[i];
                curr = curr - q;
                ++i;
                res = Math.min(res, j - i + 1);
            }

        }
        return res;
    }
}
