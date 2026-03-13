package com.sj902.dp;

public class MinCostTickets {
    Integer[][] res;

    public int mincostTickets(int[] days, int[] costs) {
        res = new Integer[days.length][days[days.length - 1]];
        return aux(days, costs, 0, 0);
    }

    private int aux(int[] days, int[] costs, int idx, int tillDays) {
        if (idx == days.length) return 0;
        int day = days[idx];
        if (res[idx][tillDays] != null) return res[idx][tillDays];
        if (day <= tillDays) {
            return aux(days, costs, idx + 1, tillDays);
        }
        int b = aux(days, costs, idx + 1, day) + costs[0];
        int c = aux(days, costs, idx + 1, Math.min(days[days.length - 1], day + 6)) + costs[1];
        int d = aux(days, costs, idx + 1, Math.min(days[days.length - 1], day + 29)) + costs[2];

        return res[idx][tillDays] = Math.min(b, Math.min(c, d));
    }
}
