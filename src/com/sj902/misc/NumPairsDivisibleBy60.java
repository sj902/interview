package com.sj902.misc;

import java.util.HashMap;

public class NumPairsDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i : time) {
            int q = i % 60;
            res = res + map.getOrDefault(60 - q, 0);
            map.put(q, map.getOrDefault(q, 0) + 1);
        }
        return res;
    }
}
