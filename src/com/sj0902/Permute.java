package com.sj0902;

import java.util.ArrayList;
import java.util.List;

public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtack(nums, 0, res);
        return res;
    }

    private void backtack(int[] nums, int start, List<List<Integer>> res) {
        if (start == nums.length) {
            List<Integer> curr = new ArrayList<>();
            for (int num : nums) {
                curr.add(num);
            }
            res.add(curr);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            backtack(nums, start + 1, res);
            swap(nums, i, start);
        }
    }

    private void swap(int[] nums, int j, int i) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
