package com.sj902.dp;

public class MincostTickets {
    Integer[][] res;

    public int mincostTickets(int[] days, int[] costs) {
        res = new Integer[days.length][days[days.length-1]+1];
        return aux(days, costs, 0, -1);
    }

    int aux(int[] days, int[] costs, int idx, int freeDaysTill) {
        if (idx >= days.length) return 0;
        if(res[idx][freeDaysTill] != null) return res[idx][freeDaysTill];
        if (freeDaysTill >= days[idx]) {
            int a = aux(days, costs, idx + 1, freeDaysTill);
            return res[idx][freeDaysTill] = a;
        } else {
            int a = costs[0] + aux(days, costs, idx + 1, days[idx]);
            int b = costs[1] + aux(days, costs, idx + 1, Math.min(days[days.length-1],days[idx] + 6));
            int c = costs[2] + aux(days, costs, idx + 1, Math.min(days[days.length-1],days[idx] + 29));
            return res[idx][freeDaysTill] = Math.min(a, Math.min(b, c));
        }
    }
}
