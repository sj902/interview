package com.sj0902.dp;

public class NumTrees {
    public int numTrees(int n) {
        int res = 0;
        if (n == 0) return 0;
        if (n == 1) return 1;
        for (int i = 1; i <= n; i++) {
            res = res + (numTrees(i-1) * numTrees(n - i));
        }
        return res;
    }
}
