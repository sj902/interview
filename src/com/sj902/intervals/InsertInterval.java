package com.sj902.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class InsertInterval {
    public int[][] insert(int[][] q, int[] newInterval) {
        int n = q.length;
        int[][] intervals = new int[n+1][2];
        for(int i = 0; i< n; ++i){
            intervals[i][0] = q[i][0];
            intervals[i][1] = q[i][1];
        }
        intervals[n][0] = newInterval[0];
        intervals[n][1] = newInterval[1];


        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int[][] res = new int[n][2];
        int i = 1;
        int len = 1;

        res[0] = intervals[0];

        while (i < n) {
            if (res[len - 1][1] >= intervals[i][0]) {
                res[len - 1][1] = Math.max(intervals[i][1], res[len - 1][1]);
            } else {
                res[len] = intervals[i];
                ++len;
            }
            ++i;
        }
        return Arrays.copyOf(res, len);
    }
}
