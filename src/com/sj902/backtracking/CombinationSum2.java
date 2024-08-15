package com.sj902.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSumAux(candidates, target, 0, new ArrayList<Integer>());
        return res;
    }

    private void combinationSumAux(int[] candidates, int target, int i, ArrayList<Integer> curr) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (target < 0 || i>=candidates.length) return;
        curr.add(candidates[i]);
        combinationSumAux(candidates, target-candidates[i], i+1, curr);
        curr.remove(curr.size()-1);
        int k = candidates[i];
        while (i< candidates.length && candidates[i]==k)++i;
        combinationSumAux(candidates, target, i, curr);
    }
}
