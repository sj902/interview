package com.sj902.misc;

import java.util.Arrays;

public class KthLargest {
    int findKthLargest(int[] nums, int k) {
        if (nums.length == 1) return nums[0];
        return aux(nums, nums.length - k - 1, 0, nums.length - 1);
    }

    private int aux(int[] nums, int k, int start, int end) {
        int pivot = partition(nums, start, end);
        if (pivot == k) return nums[pivot];
        if (pivot > k) return aux(nums, k, start, pivot - 1);
        else return aux(nums, pivot, pivot + 1, end);
    }

    private int partition(int[] nums, int start, int end) {
        int p = start;
        int l = start + 1;
        int h = end;
        while (l <= h) {
            while (l<=end && nums[l] < nums[p]) {
                ++l;
            }
            while (h>=start && nums[h] > nums[p]) {
                --h;
            }
            if (l < h) {
                int t = nums[l];
                nums[l] = nums[h];
                nums[h] = t;
            }
        }
        int t = nums[p];
        nums[p] = nums[h];
        nums[h] = t;
        return h;
    }
}
