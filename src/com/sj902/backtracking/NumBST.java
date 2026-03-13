package com.sj902.backtracking;

public class NumBST {
    public int numTrees(int n) {
        Integer[] res = new Integer[n + 1];
        res[0] = 1;
        res[1] = 1;
        for (int i = 2; i <= n; i++) {
            res[i] = 0;
            int k = i - 1;
            for (int j = 0; j < i; j++) {
                int l = k - j;
                res[i] = res[l] * res[i];
            }
        }
        return res[n];
    }
}
