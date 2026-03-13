package com.sj902.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Permutation{
    public static void main(String[] args) {
        System.out.println(new Sol().permute(new int[]{1,2,3}));
    }
}

 class Sol {
    List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        aux(nums, 0);
        return res;
    }

    private void aux(int[] nums, int idx) {
        if(idx == nums.length) System.out.println(Arrays.toString(nums));
        for (int i = idx; i < nums.length; i++) {
            swap(nums, i, idx);
            aux(nums, idx+1);
            swap(nums, i, idx);
        }
    }

    private void swap(int[] nums, int i, int idx) {
        int t = nums[i];
        nums[i] = nums[idx];
        nums[idx] = t;
    }
}
