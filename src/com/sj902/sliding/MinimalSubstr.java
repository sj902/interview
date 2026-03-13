package com.sj902.sliding;

import java.util.HashMap;

public class MinimalSubstr {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int counter = map.size();

        int begin = 0, end = 0;
        int head = 0;
        int len = Integer.MAX_VALUE;

        while (end < s.length()) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) counter--;
            }
            end++;

            while (counter == 0) {
                char q = s.charAt(begin);
                if (map.containsKey(q)) {
                    map.put(q, map.get(q) + 1);
                    if (map.get(q) > 0) counter++;
                }
                if (end - begin < len) {
                    len = end - begin;
                    head = begin;
                }
                ++begin;
            }
        }

        if (len == Integer.MAX_VALUE) return "";
        return s.substring(head, head + len);
    }
}
