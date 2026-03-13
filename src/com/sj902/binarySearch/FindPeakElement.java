package com.sj902.binarySearch;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int h = nums.length - 1;
        while (l <= h) {
            int m = l + ((h - l) / 2);
            if ((m == 0 || nums[m] > nums[m - 1]) && (m == nums.length - 1 || nums[m] > nums[m + 1])) return m;
            boolean ill = m == 0 || nums[m]>nums[m-1];
            if(ill) l = m+1;
            else h = m-1;
        }

        return nums[nums.length - 1];
    }
}
