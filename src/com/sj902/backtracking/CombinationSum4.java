package com.sj902.backtracking;

public class CombinationSum4 {
    int res;

    public int combinationSum4(int[] nums, int target) {
        res = 0;
        aux(nums, target, 0, 0);
        return res;
    }

    private void aux(int[] nums, int target, int idx, int currSum) {
        if(currSum == target) {
            ++res;
            return;
        }
        if(currSum > target)return;
        if(idx>=nums.length)return;
        for (int i = 0; i < nums.length; i++) {
            aux(nums, target, i, currSum+nums[i]);
        }
    }
}
