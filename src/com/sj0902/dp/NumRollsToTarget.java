package com.sj0902.dp;

public class NumRollsToTarget {
    public int numRollsToTarget(int n, int k, int target) {
        if (target < 0 || n == 0) return 0;
        if (n == 1) return (target <= k) ? 1 : 0;

        int ways = 0;

        for (int i = 1; i <= k; i++) {
            ways = (ways + numRollsToTarget(n - 1, k, target - i)) % 1000000007;
        }

        return ways;

    }
}
