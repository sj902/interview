package com.sj902.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        if(s.length()<1) return new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        int[] walk = new int[s.length()];
        int maxCurr = map.get(s.charAt(0));
        int prev = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int max = map.get(ch);
            if(i>maxCurr){
                res.add(i-prev);
                prev = i;
            }
            maxCurr = Math.max(max, maxCurr);
        }
        res.add(s.length()-prev);
        return res;
    }
}
