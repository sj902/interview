package com.sj902.arrays;

import java.util.HashMap;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int begin = 0;
        int end = 0;
        int counter = 0;
        int res = 0;
        while (end < n) {
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) > 1) counter++;
            ++end;
            while (counter > 0) {
                char q = s.charAt(begin);
                map.put(q, map.get(q) - 1);
                if (map.get(q) == 1) counter--;
                ++begin;
            }
            res = Math.max(res, end - begin);
        }
        return res;
    }
}
