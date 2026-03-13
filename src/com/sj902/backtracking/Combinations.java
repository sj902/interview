package com.sj902.backtracking;

import java.util.ArrayList;
import java.util.List;

class C{
    public static void main(String[] args) {
        Combinations c = new Combinations();
        c.combine(4,2);
        System.out.println(c.res);
    }
}

public class Combinations {

    List<List<Integer>> res;
    int[] nums;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        aux(0, new ArrayList<>(), k);
        return res;
    }

    private void aux(int idx, ArrayList<Integer> curr, int k) {
        if (curr.size() == k) {
            res.add(new ArrayList<>(curr));
        }
        for (int i = idx; i < nums.length; i++) {
            curr.add(nums[i]);
            aux(i + 1, curr, k);
            curr.remove(curr.size() - 1);
        }
    }
}
