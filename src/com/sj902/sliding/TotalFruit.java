package com.sj902.sliding;

import java.util.HashMap;
import java.util.HashSet;

public class TotalFruit {

    public static void main(String[] args) {
        System.out.println(totalFruit(new int[]{1, 2, 1}));
    }

    public static int totalFruit(int[] s) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int begin = 0;
        int end = 0;
        int res = 0;
        while (end < s.length) {
            int c = s[end];
            map.put(s[end], map.getOrDefault(s[end], 0) + 1);
            end++;
            int counter = map.size();
            while (counter > 2) {
                int q = s[begin];
                map.put(q, map.get(q) - 1);
                if (map.get(q) == 0) {
                    map.remove(q);
                }
                counter = map.size();
                ++begin;
            }
            res = Math.max(res, end - begin + 1);
        }
        return res;
    }

}
