package com.sj902.greedy;

import java.util.Arrays;
import java.util.HashSet;

public class FindMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int[][] arr = new int[points.length][2];
        arr[0] = points[0];
        int i = 1;
        int k = 0;
        while (i < points.length) {
            if (arr[k][1] >= points[i][0]) {
                arr[k][0] = points[i][0];
                arr[k][1] = Math.min(points[i][1], arr[k][1]);
            } else {
                ++k;
                arr[k] = points[i];
            }
            ++i;
        }
        return k;
    }
}
