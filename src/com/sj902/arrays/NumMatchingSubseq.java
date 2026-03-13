package com.sj902.arrays;

import java.util.ArrayList;
import java.util.HashMap;

public class NumMatchingSubseq {
    public int numMatchingSubseq(String s, String[] words) {
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        HashMap<String, Boolean> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            ArrayList<Integer> a = map.getOrDefault(c, new ArrayList<>());
            a.add(i);
            map.put(c, a);
        }
        int res = 0;
        for (String word : words) {
            if (map2.containsKey(word)) {
                if (map2.get(word)) {
                    ++res;
                }
            } else {
                int l = -1;
                boolean fail = false;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if (!map.containsKey(c)) {
                        fail = true;
                        break;
                    }
                    ArrayList<Integer> a = map.get(c);
                    int y = 0;
                    while (y < a.size()) {
                        int w = a.get(y);
                        if (w > l) break;
                        ++y;
                    }
                    if (y == a.size()) {
                        fail = true;
                        break;
                    }
                    l = a.get(y);
                }
                map2.put(word, !fail);
                if (!fail) ++res;
            }
        }
        return res;
    }
}
