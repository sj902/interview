package com.sj902.greedy;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 1) {
                nums[i] = n + 2;
            }
        }

        for (int i = 0; i < n; ++i) {
            int idx = nums[i] - 1;
            if (idx - 1 < n && nums[idx] > 0) {
                nums[idx] = nums[idx] * -1;
            }
        }

        int i = 0;
        for (i = 0; i < n; ++i) {
            if(nums[i]>=0){
                return i;
            }
        }

        return i;
    }
}
