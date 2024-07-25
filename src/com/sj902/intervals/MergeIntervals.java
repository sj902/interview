package com.sj902.intervals;

import java.util.Arrays;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int len = 1;
        int i = 1;
        int n = intervals.length;
        int[][] res = new int[n][2];

        res[0] = intervals[0];

        while (i < n) {
            if (res[len - 1][1] > intervals[i][0]) {
                res[len - 1][1] = Math.max(res[len - 1][1], intervals[i][1]);
            } else {
                res[len] = intervals[i];
                ++len;
            }
            ++i;
        }

        return Arrays.copyOf(res, len);
    }
}
