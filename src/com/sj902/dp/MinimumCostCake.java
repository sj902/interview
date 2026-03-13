package com.sj902.dp;

public class MinimumCostCake {
    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        return minimumCostAux(m - 1, n - 1, horizontalCut, verticalCut, 0, 0);
    }

    int minimumCostAux(int m, int n, int[] horizontalCut, int[] verticalCut, int hIndex, int vIndex) {
        if (hIndex - m == 1 && vIndex - n == 1) return 0;
        int cost = Integer.MAX_VALUE;
        for (int i = 1; i <= m; i++) {
            cost = Math.min(
                    minimumCostAux(i, n, horizontalCut, verticalCut, hIndex + i, vIndex) + horizontalCut[hIndex + i - 1],
                    cost);
        }
        for (int i = 1; i < n; i++) {
            cost = Math.min(minimumCostAux(m, i, horizontalCut, verticalCut, hIndex, vIndex + i) + verticalCut[vIndex + i - 1], cost);
        }
        return cost;
    }
}
