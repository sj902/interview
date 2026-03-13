package com.sj902.arrays;

public class IsZeroArray {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] line = new int[nums.length + 1];
        for (int[] a : queries) {
            line[a[0]]++;
            line[a[1] + 1]--;
        }

        int[] prefix = new int[nums.length + 1];
        prefix[0] = line[0];
        if (prefix[0] < nums[0]) return false;


        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + line[i];
            if (prefix[i] < nums[i]) {
                return false;
            }
        }

        return true;
    }
}