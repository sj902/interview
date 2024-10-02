package com.sj902.arrays;

import java.util.Arrays;
import java.util.HashMap;

public class ArrayRankTransform {
    public int[] arrayRankTransform(int[] arr) {
        int[] cp = Arrays.copyOf(arr, arr.length);
        Arrays.sort(cp);
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(cp[0], 1);
        int prev = cp[0];
        for (int i = 1; i < cp.length; i++) {
            if (cp[i] > prev) {
                map.put(cp[i], map.get(prev) + 1);
                prev = cp[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            cp[i] = map.get(arr[i]);
        }
        return cp;
    }
}
