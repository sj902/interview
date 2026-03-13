package com.sj0902;

import java.util.ArrayList;
import java.util.List;

public class Combine {
    int[] nums;

    public List<List<Integer>> combine(int n, int k) {
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        List<List<Integer>> res = new ArrayList<>();
        aux(new ArrayList<>(), res, 0, k);
        return res;
    }

    private void aux(ArrayList<Integer> curr, List<List<Integer>> res, int idx, int k) {
        if (curr.size() == k) {
            List<Integer> arr = new ArrayList<>(curr);
            res.add(arr);
        }
        for (int i = idx; i < nums.length; i++) {
            curr.add(nums[idx]);
            aux(curr, res, idx + 1, k);
            curr.remove(curr.size() - 1);
        }
    }
}
