package com.sj902.backtracking;

public class NumBST {
    Integer[] res;
    public int numTrees(int n) {
        if(res == null) res = new Integer[n+1];
        if (n == 0) return 1;
        if (n == 1) return 1;
        if(res[n] != null) return res[n];
        int r = 0;
        for (int i = 1; i <= n; i++) {
            r = r + (numTrees(n - i) * numTrees(i - 1));
        }
        return res[n] = r;
    }
}
