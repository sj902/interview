package com.sj902.sliding;

import java.util.HashMap;

public class SubarraysWithKDistinct {
    public static void main(String[] args) {
        System.out.println(subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2));
    }

    public static int subarraysWithKDistinct(int[] s, int k) {
        return subarraysWithKDistinctAux(s, k) - subarraysWithKDistinctAux(s, k - 1);
    }

    public static int subarraysWithKDistinctAux(int[] s, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int begin = 0;
        int end = 0;
        int res = 0;
        int counter = 0;


        while (end < s.length) {
            int c = s[end];
            map.put(c, map.getOrDefault(c, 0) + 1);
            counter = map.size();
            end++;
            while (counter > k) {
                int q = s[begin];
                map.put(q, map.get(q) - 1);
                if (map.get(q) == 0) {
                    counter--;
                    map.remove(q);
                }
                ++begin;
            }
            if (map.size() <= k) {
                int newRes = end-begin;
                System.out.println("-->" + begin + "::" + end + "::" + newRes);
                res = res + newRes;
            }
        }
        return res;
    }
}
