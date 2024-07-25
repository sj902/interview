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
        int counter = 0;


        while (end < s.length) {
            int c = s[end];
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.size() > 2) counter++;

            end++;

            while (counter > 0) {
                int q = s[begin];
                map.put(q, map.get(q) - 1);
                if (map.get(q) == 0) {
                    counter--;
                }
                begin++;
            }
            res = Math.max(res, end - begin);
        }
        return res;
    }

}
