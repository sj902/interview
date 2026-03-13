package com.sj0902.sliding;

import java.util.HashMap;

public class MinWindowSubstring {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int counter = map.size();
        int l = 0;
        int r = 0;
        int head = 0;
        int len = Integer.MAX_VALUE;

        while (r<s.length()){
            char c = s.charAt(r);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) counter--;
            }
            ++r;
            while (counter == 0) {
                char q = s.charAt(l);
                if (map.containsKey(q)) {
                    map.put(q, map.get(q) + 1);
                    if (map.get(q) > 0) counter++;
                }
                if(r-l < len){
                    len = r - l;
                    head = l;
                }
                ++ l;
            }
        }
        if(len == Integer.MAX_VALUE) return "";
        return s.substring(head, head+len);
    }
}
