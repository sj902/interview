package com.sj902.arrays;

import java.util.Arrays;
import java.util.HashMap;

public class ArrayRankTransform {
    public int[] arrayRankTransform(int[] arr) {
        int[] cp = Arrays.copyOf(arr, arr.length);
        Arrays.sort(cp);
        HashMap<Integer, Integer> map = new HashMap<>();
        int prev = Integer.MIN_VALUE;
        map.put(prev, 0);
        for (int j : cp) {
            if (j > prev) {
                map.put(j, map.get(prev) + 1);
                prev = j;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            cp[i] = map.get(arr[i]);
        }
        return cp;
    }
}
