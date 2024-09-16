package com.sj902.misc;

import java.util.Collections;
import java.util.List;

public class FindMinDifference {
    public int findMinDifference(List<String> timePoints) {
        timePoints.addAll(timePoints);
        Collections.sort(timePoints);
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < timePoints.size(); i++) {
            int diff = getDiff(timePoints.get(i), timePoints.get(i - 1));
            res = Math.min(res, diff);
        }
        return res;
    }

    private int getDiff(String s, String s1) {
        String[] t1 = s1.split(":");
        String[] t = s.split(":");
        int h1 = Integer.parseInt(t1[0]);
        int h = Integer.parseInt(t[0]);
        int m1 = Integer.parseInt(t1[0]);
        int m = Integer.parseInt(t[0]);
        int hourDif = (h1 - h) * 60;
        int minDiff = m1 - m;
        return hourDif + minDiff;
    }

}
