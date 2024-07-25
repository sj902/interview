package com.sj902.sliding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindSubstring {
    public List<Integer> findSubstring(String s, String[] words) {
        int len = words[0].length();
        List<Integer> result = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> target = new HashMap<>();
        int counter = 0;
        for (String t : words) {
            map.put(t, map.getOrDefault(t, 0) + 1);
            ++counter;
        }

        int found = 0;
        int begin = 0;
        int end = 0;


        while (end + len <= s.length()) {
            String c = s.substring(end, end + len);
            if (map.containsKey(c)) {
                counter--;
            } else {
                ++end;
            }

            while (counter == 0) {

            }

            if (counter == 0) {
                result.add(begin);
                counter = map.size();
            }

        }
        return result;
    }
}
