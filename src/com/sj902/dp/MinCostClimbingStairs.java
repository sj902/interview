package com.sj902.dp;

public class MinCostClimbingStairs {
    int[] res;

    public int minCostClimbingStairs(int[] cost) {
        res = new int[cost.length + 1];
        if (cost.length == 1) return cost[0];


        for (int i = 0; i <= cost.length; i++) {
            res[i] = Integer.MAX_VALUE;
        }

        res[cost.length] = 0;
        return Math.min(minCostClimbingStairsAux(cost, 0), minCostClimbingStairsAux(cost, 1));
    }

    public int minCostClimbingStairsAux(int[] cost, int i) {
        if (i > cost.length) return Integer.MAX_VALUE;

        if (res[i] != Integer.MAX_VALUE) return res[i];

        if (i < cost.length) {
            int oneStep = minCostClimbingStairsAux(cost, i + 1);
            int twoSteps = minCostClimbingStairsAux(cost, i + 2);
            res[i] = cost[i] + Math.min(oneStep, twoSteps);
        }
        return res[i];
    }
}
