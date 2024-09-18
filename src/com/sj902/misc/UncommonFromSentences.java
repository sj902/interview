package com.sj902.misc;

import java.util.HashMap;
import java.util.HashSet;

public class UncommonFromSentences {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String s: s1.split(" ")){
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        for(String s: s2.split(" ")){
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        HashSet<String> res = new HashSet<>();
        for(String s: map.keySet()){
            if(map.get(s) == 1){
                res.add(s);
            }
        }
        return res.toArray(new String[0]);
    }
}
