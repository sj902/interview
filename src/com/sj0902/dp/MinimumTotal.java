package com.sj0902.dp;

import java.util.List;

public class MinimumTotal {
    List<List<Integer>> t;
    Integer[][] dp;

    public int minimumTotal(List<List<Integer>> triangle) {
        t = triangle;
        int m = triangle.size();
        if (triangle.size() == 0) {
            return 0;
        }
        int n = t.get(m - 1).size();
        dp = new Integer[m][n];
        return triangle.get(0).get(0) + Math.min(aux(1, 0), aux(1, 1));
    }

    private int aux(int level, int index) {
        if (level == t.size()) return 0;
        List<Integer> s = t.get(level);
        if (index >= s.size()) return Integer.MIN_VALUE;
        if (dp[level][index] != null) return dp[level][index];
        int left = aux(level + 1, index);
        int right = aux(level + 1, index + 1);
        int l = Integer.MAX_VALUE;
        int r = Integer.MAX_VALUE;

        if (left != Integer.MIN_VALUE) {
            l = left;
        }

        if (right != Integer.MIN_VALUE) {
            r = right;
        }

        return dp[level][index] = t.get(level).get(index) + Math.min(l, r);
    }
}
