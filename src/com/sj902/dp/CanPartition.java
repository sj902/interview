package com.sj902.dp;

public class CanPartition {
    boolean[][] res;
    boolean[][] visited;

    public boolean canPartition(int[] nums) {
        int n = nums.length;

        res = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1][n + 1];

        int s = 0;
        for (int i = 0; i < n; i++) {
            s = s + nums[i];
        }
        if (s % 2 == 1) return false;
        return canPartition(nums, s / 2, n - 1);
    }

    public boolean canPartition(int[] nums, int target, int i) {
        if (i < 0) return false;
        if (target == 0) return true;
        if (visited[target][i]) return res[target][i];
        boolean include = canPartition(nums, target - nums[i], i - 1);
        boolean exclude = canPartition(nums, target, i - 1);
        return res[target][i] = include || exclude;
    }
}
