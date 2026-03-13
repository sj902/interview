package com.sj902.dp;

public class LastStoneWeightII {
    int[] nums;
    Integer[][] res;

    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
        }
        res = new Integer[stones.length + 1][sum + 1];
        nums = stones;
        return aux(0, 0);
    }

    int aux(int idx, int curr) {
        if (idx >= nums.length) return Math.abs(curr);
        if (res[idx][curr] != null) return res[idx][curr];
        int plus = aux(idx + 1, nums[idx] + curr);
        int minus = aux(idx + 1, Math.abs(curr - nums[idx]));
        return res[idx][curr] = Math.min(plus, minus);
    }
}
