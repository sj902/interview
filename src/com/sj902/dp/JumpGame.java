package com.sj902.dp;

import java.util.Arrays;

public class JumpGame {
    int res1[];

    public boolean canJump1(int[] nums) {
        res1 = new int[nums.length + 1];
        Arrays.fill(res1, -1);
        return canJumpAux(nums, 0);
    }

    private boolean canJumpAux(int[] nums, int idx) {
        if (idx >= nums.length - 1) return true;
        if (nums[idx] == 0) return false;
        if (res1[idx] != -1) return res1[idx] == 1;
        for (int i = 1; i <= nums[idx]; i++) {
            boolean f = canJumpAux(nums, idx+i);
            if (f) {
                res1[idx] =1;
                return true;
            }
        }
        res1[idx] = 0;
        return false;
    }


    public boolean canJump(int[] nums) {
        int reach = 0;
        for (int i = 0; i < nums.length+1; i++) {
            reach = Math.max(reach, i+nums[i]);
        }
        return reach>=nums.length-1;
    }

}
