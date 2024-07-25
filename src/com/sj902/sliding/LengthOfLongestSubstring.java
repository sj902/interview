package com.sj902.sliding;

import java.util.HashMap;
import java.util.HashSet;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int begin = 0;
        int end = 0;
        int counter = 0;
        int res = 0;

        while (end < s.length()) {
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) > 1) counter++;
            end++;

            while (counter > 0) {
                char q = s.charAt(begin);
                if (map.get(q) > 1) counter--;
                map.put(q, map.getOrDefault(q, 0) - 1);
                ++begin;
            }
            res = Math.max(res, end - begin);
        }

        return res;
    }
}
