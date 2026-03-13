package com.sj902.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PernuteUniq {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        permuteAux(nums, 0, res);
        return res;
    }

    private void permuteAux(int[] nums, int start, List<List<Integer>> res) {
        if(nums.length == start){
            List<Integer> q = new ArrayList<>();
            for (int y : nums) {
                q.add(y);
            }
            res.add(q);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums,i,start);
            while(nums[i]==nums[start])++i;
            permuteAux(nums,start+1,res);
            swap(nums,i,start);
        }
    }

    private void swap(int[] nums, int i, int start) {
        int t = nums[start];
        nums[start] = nums[i];
        nums[i] = t;
    }
}
