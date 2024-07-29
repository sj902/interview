package com.sj902.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class permute {

    public static void main(String[] args) {
        permute(new int[]{1, 2, 3});
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permuteAux(nums, 0, res);
        return res;
    }

    private static void permuteAux(int[] nums, int start, List<List<Integer>> res) {
        if (start == nums.length) {
            ArrayList<Integer> q = new ArrayList<>();
            for (int k : nums) {
                q.add(k);
            }
            res.add(q);

            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            permuteAux(nums, start + 1, res);
            swap(nums, start, i);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
