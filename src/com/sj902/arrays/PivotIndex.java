package com.sj902.arrays;

public class PivotIndex {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] suf = new int[n];
        pre[0] = 0;
        suf[0] = 0;

        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            suf[i] = suf[i + 1] + nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            if (pre[i] == suf[i]) return i;
        }

        return -1;
    }
}
