package com.sj902.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MyCalendarTwo {
    List<int[]> sgl;
    List<int[]> dbl;

    public MyCalendarTwo() {
        sgl = new ArrayList<>();
        dbl = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] d : dbl) {
            if (overlaps(d[0], d[1], start, end)) {
                return false;
            }
        }

        for (int[] s : sgl) {
            if (overlaps(s[0], s[1], start, end)) {
                addToDouble(s[0], s[1], start, end);
                return true;
            }
        }

        sgl.add(new int[]{start, end});
        return true;
    }

    private void addToDouble(int a1, int b1, int a2, int b2) {
        int start = Math.max(a1, a2);
        int end = Math.min(b1, b2);
        dbl.add(new int[]{start,end});
    }

    private boolean overlaps(int a1, int b1, int a2, int b2) {
        return Math.max(a1, a2) < Math.min(b1, b2);
    }
}
