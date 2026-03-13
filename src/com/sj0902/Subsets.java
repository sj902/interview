package com.sj0902;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        aux(nums, 0, res, new ArrayList<Integer>());
        return res;
    }

    private void aux(int[] nums, int idx, List<List<Integer>> res, ArrayList<Integer> curr) {
        if(idx == nums.length){
            res.add(new ArrayList<>(curr));
        }
        curr.add(nums[idx]);
        aux(nums, idx+1, res, curr);
        curr.remove(curr.size()-1);
        aux(nums, idx+1, res, curr);
    }


}
