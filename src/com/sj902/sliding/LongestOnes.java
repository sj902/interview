package com.sj902.sliding;

import java.util.HashMap;

public class LongestOnes {
    public int longestOnes(int[] s, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int begin = 0;
        int end = 0;
        int len = 0;
        int counter = 0;

        while (end<s.length){
            int c = s[end];
            map.put(c, map.getOrDefault(c, 0)+1);
            counter = map.getOrDefault(0, 0);
            ++end;
            while(counter>k){
                int q = s[begin];
                if (q == 0) {
                    map.put(q, map.get(q)-1);
                    --counter;
                }
                ++begin;
            }
            len = Math.max(len, end-begin+1);
        }
        return len;
    }
}
