package com.sj902.arrays;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class MaximumBeauty {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> (Integer.compare(a[0], b[0])));
        TreeMap<Integer, Integer> tmap = new TreeMap<>();
        int currMax = -1;
        for (int[] item : items) {
            currMax = Math.max(currMax, item[1]);
            tmap.put(item[0], currMax);
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (tmap.ceilingKey(queries[i]) == null) {
                res[i] = 0;
            } else {
                res[i] = tmap.get(tmap.ceilingKey(queries[i]));
            }
        }
        return res;
    }
}
