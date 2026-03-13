package com.sj902.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FindAndReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for(String s: words){
            if(pattern.length() != s.length()){
                continue;
            }
            boolean isFine = true;
            HashMap <Character, Character> map = new HashMap<>();
            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < pattern.length(); i++) {
                char a = pattern.charAt(i);
                char b = s.charAt(i);
                if(!map.containsKey(a)){
                    if(set.contains(b)){
                        isFine = false;
                        break;
                    } else {
                        set.add(b);
                        map.put(a, b);
                    }
                } else if (map.get(a)!=b) {
                    isFine = false;
                    break;
                }
            }
            if(isFine){
                res.add(s);
            }
        }
        return res;
    }
}
