package com.sj902.backtracking;

import java.util.ArrayList;
import java.util.List;

public class combinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        combinationSumAux(candidates, target, res, new ArrayList<Integer>(), 0, 0);
        return res;
    }

    private void combinationSumAux(int[] candidates, int target, List<List<Integer>> res, ArrayList<Integer> curr, int currSum, int index) {
        if (currSum == target) {
            res.add(curr);
            return;
        }
        if (currSum > target) return;
        curr.add(candidates[index]);
        combinationSumAux(candidates, target, res, curr, currSum+candidates[index], index);
        curr.remove(curr.size()-1);
        combinationSumAux(candidates, target, res, curr, currSum, index+1);
    }


}
