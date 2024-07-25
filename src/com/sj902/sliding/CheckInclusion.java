package com.sj902.sliding;

import java.util.HashMap;

public class CheckInclusion {
    public boolean checkInclusion(String s, String t) {
        if (s.length() > t.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> tmap = new HashMap<>();

        int i = 0;
        while (i < s.length()) {
            char c = t.charAt(i);
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);
            ++i;
        }


        int begin = 1;
        int end = s.length() - 1;


        while (end + 1 < (t.length())) {
            if (isEqual(map, tmap)) return true;
            char prev = t.charAt(begin - 1);
            tmap.put(prev, tmap.get(prev) - 1);
            if (tmap.get(prev) == 0) tmap.remove(prev);
            ++end;
            ++begin;
            char next = t.charAt(end);
            tmap.put(next, tmap.getOrDefault(next, 0) + 1);
        }
        if (isEqual(map, tmap)) return true;
        return false;
    }

    boolean isEqual(HashMap<Character, Integer> a, HashMap<Character, Integer> b) {
        if (a.size() != b.size()) return false;
        for (char c : a.keySet()) {
            int q = a.get(c);
            int w = b.getOrDefault(c, 0);
            if (q != w) return false;
        }
        return true;
    }
}
