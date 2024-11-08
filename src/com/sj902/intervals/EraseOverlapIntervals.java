package com.sj902.intervals;

import java.util.Arrays;
import java.util.Comparator;

public class EraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        int res = 0;
        int prev = 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for (int i = 1; i < intervals.length; i++) {
           if(intervals[i][0]<=intervals[i-1][1]){
               ++ res;
               intervals[i][1] = Math.max( intervals[i][1] ,  intervals[i-1][1] );
           }
        }
        return res;
    }
}
