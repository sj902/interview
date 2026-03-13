package com.sj902.sliding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String t) {
        List<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);

        int counter = map.size();

        int begin = 0;
        int end = 0;

        while (end < s.length()) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) counter--;
            }

            end++;

            while (counter == 0) {
                char q = s.charAt(begin);
                if (end - begin == t.length()) {
                    res.add(begin);
                }
                if (map.containsKey(q)) {
                    map.put(q, map.get(q) + 1);
                    if (map.get(q) > 0) counter++;
                }
                begin++;
            }
        }
        return res;
    }
}
