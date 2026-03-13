package com.sj0902.sliding;

import java.util.HashMap;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        int res = 0;

        while (r < s.length()) {
            char ch = s.charAt(r);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            ++r;
            while (map.get(ch) > 1) {
                char q = s.charAt(l);
                map.put(q, map.get(q)-1);
                ++l;
            }
            res = Math.max(res, r - l);
        }

        return res;

    }
}
