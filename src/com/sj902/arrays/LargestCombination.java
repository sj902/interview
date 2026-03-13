package com.sj902.arrays;

import java.util.HashMap;
import java.util.Hashtable;

public class LargestCombination {
    public int largestCombination(int[] candidates) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 32; i++) {
            map.put(i, 0);
        }

        for (int candidate : candidates) {
            fillMap(candidate, map);
        }

        int max = 0;
        for (Integer i : map.keySet()) {
            max = Math.max(map.get(i), max);
        }
        return max;
    }

    private void fillMap(int c, HashMap<Integer, Integer> map) {
        String str = new StringBuilder(Integer.toBinaryString(c)).reverse().toString();
        System.out.println(c+"::"+str+"::"+str.charAt(0));
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '1') {
                map.put(i, map.get(i) + 1);
            }
        }
    }
}
