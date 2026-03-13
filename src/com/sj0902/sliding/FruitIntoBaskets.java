package com.sj0902.sliding;

import java.util.HashMap;

public class FruitIntoBaskets {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int l = 0;
        int r = 0;

        int res = 0;

        while (r < fruits.length) {
            int c = fruits[r];
            map.put(c, map.getOrDefault(c, 0) + 1);
            ++r;
            while (map.size() > 2) {
                int t = fruits[l];
                map.put(t, map.get(t) - 1);
                if (map.get(t) == 0) {
                    map.remove(t);
                }
                ++l;
            }
            res = Math.max(res, r - l);
        }
        return res;
    }
}
