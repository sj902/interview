package com.sj902.dp;

import java.util.List;

public class TriangleMinPathSum {
    Integer[][] res;

    public int minimumTotal(List<List<Integer>> triangle) {
        res = new Integer[triangle.size() + 1][triangle.size() + 1];
        int n = triangle.size();
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < triangle.get(n - 1).size(); i++) {
            int a = aux(triangle, triangle.size() - 2, i - 1);
            int b = aux(triangle, triangle.size() - 2, i);
            if (a < Integer.MAX_VALUE) a = a + triangle.get(n - 1).get(i);
            if (b < Integer.MAX_VALUE) b = b + triangle.get(n - 1).get(i);
            res = Math.min(res, Math.min(a, b));
        }
        return res;
    }

    private int aux(List<List<Integer>> triangle, int level, int idx) {
        if (level < 0) return 0;
        if (level == 0) return triangle.get(0).get(0);
        if (idx < 0) return Integer.MAX_VALUE;
        if (idx >= triangle.get(level).size()) return Integer.MAX_VALUE;
        if (res[level][idx] != null) return res[level][idx];
        int curr = triangle.get(level).get(idx);
        int a = aux(triangle, level - 1, idx - 1);
        int b = aux(triangle, level - 1, idx);
        if (a < Integer.MAX_VALUE) a = a + curr;
        if (b < Integer.MAX_VALUE) b = b + curr;
        return res[level][idx] = Math.min(a, b);
    }
}
