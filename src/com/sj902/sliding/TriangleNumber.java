package com.sj902.sliding;

import java.util.Arrays;

public class TriangleNumber {

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            int l = 0;
            int r = i - 1;
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum > nums[i]) {
                    count ++;
                    --r;
                } else {
                    l++;
                }
            }
        }

        return count;
    }

}
