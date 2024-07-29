package com.sj902.arrays;

public class SortedSquares {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int l = 0;
        int r = n - 1;
        int i = 0;

        while (l <= r) {
            if (nums[l] > nums[r]) {
                res[n - 1 - i] = nums[l] * nums[l];
                ++l;
                ++i;
            } else {
                res[n - 1 - i] = nums[r] * nums[r];
                --r;
                ++i;
            }
        }
        return res;
    }
}
