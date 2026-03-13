package com.sj0902.dp;

public class MinFallingPathSum {
    int[][] m;
    Integer dp[][];

    public int minFallingPathSum(int[][] matrix) {
        m = matrix;
        dp = new Integer[matrix.length][matrix[0].length];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < matrix[0].length; i++) {
            res = Math.min(res, aux(0, i));
        }
        return res;
    }

    private int aux(int level, int idx) {
        if (level == m.length) return 0;
        if (dp[level][idx] != null) return dp[level][idx];
        int min = Integer.MAX_VALUE;
        for (int i = Math.max(0, idx - 1); i <= Math.min(idx + 1, m[0].length - 1); i++) {
            min = Math.min(min, aux(level + 1, i));
        }
        return dp[level][idx] = m[level][idx] + min;
    }
}
