package com.sj902.dp;

import java.util.Arrays;

public class JumpGame2 {
    int res[];

    public int jump(int[] nums) {
        res = new int[nums.length];
        Arrays.fill(res, -1);
        return jumpAux(nums, 0);
    }

    private int jumpAux(int[] nums, int idx) {
        if (idx == nums.length - 1) return 0;
        if (idx >= nums.length) return Integer.MAX_VALUE;
        if (res[idx] != -1) return res[idx];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= nums[idx]; i++) {
            min = Math.min(min, jumpAux(nums, idx + i));
        }
        if (min != Integer.MAX_VALUE) {
            return res[idx] = min + 1;
        } else return res[idx] = min;
    }
}
