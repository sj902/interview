package com.sj0902.dp;

public class MincostTickets {
    int[] d;
    int[] c;

    public int mincostTickets(int[] days, int[] costs) {
        d = days;
        c = costs;
        return aux(0, 0);
    }

    private int aux(int idx, int day) {
        if (idx >= d.length) {
            return 0;
        }
        int exclude = Integer.MAX_VALUE;
        if (day >= d[idx]) {
            exclude = aux(idx + 1, day);
        }
        int c1 = c[0] + aux(idx + 1, day + 1);
        int c7 = c[1] + aux(idx + 1, day + 7);
        int c30 = c[2] + aux(idx + 1, day + 30);
        return Math.min(exclude, Math.min(c1, Math.min(c7, c30)));
    }
}
