package com.sj902.dynamicProgramming;

public class MincostTickets {
    int[] nums;
    int[] cost;
    Integer[] res;

    public int mincostTickets(int[] days, int[] costs) {
        res = new Integer[days.length + 1];
        nums = days;
        cost = costs;
        return aux(0);
    }

    private int aux(int idx) {
        if (idx >= nums.length) return 0;
        if (res[idx] != null) return res[idx];
        int a = cost[0] + aux(idx + 1);
        int j = idx;
        int next = nums[idx] + 6;
        while (j < nums.length && nums[j] <= next) ++j;
        int b = cost[1] + aux(j);
        j = idx;
        next = nums[idx] + 29;
        while (j < nums.length && nums[j] <= next) ++j;
        int c = cost[2] + aux(j);
        return res[idx] = Math.min(a, Math.min(b, c));
    }
}
