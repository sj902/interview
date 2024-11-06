package com.sj902.arrays;

import java.util.ArrayList;

public class CanSortArray {
    public boolean canSortArray(int[] nums) {
        ArrayList<Integer> mins = new ArrayList<>();
        ArrayList<Integer> maxs = new ArrayList<>();

        for (int i = 0; i < nums.length; ) {
            int min = i;
            int max = i;
            int currCount = Integer.bitCount(nums[i]);
            while (i < nums.length && currCount == Integer.bitCount(nums[i])) {
                if (nums[i] < nums[min]) min = i;
                if (nums[i] > nums[max]) max = i;
                ++i;
            }
            mins.add(min);
            maxs.add(max);
        }
        for (int i = 0; i < mins.size() - 1; i++) {
            if (nums[maxs.get(i)] > nums[mins.get(i + 1)]) {
                return false;
            }
        }

        return true;
    }
}
