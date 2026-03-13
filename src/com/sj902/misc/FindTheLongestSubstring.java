package com.sj902.misc;

import java.util.HashMap;

public class FindTheLongestSubstring {
    public int findTheLongestSubstring(String s) {
        int n = s.length();
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,0);
        int res = 0;
        int[] prefix = new int[n+1];
        prefix[0] = 0;
        for (int i = 0; i < n; i++) {
            prefix[i+1] = getBitmap(prefix[i], s.charAt(i));
            System.out.println(Integer.toBinaryString(prefix[i+1]));
            if(map.containsKey(prefix[i+1])){
                int start = map.get(prefix[i+1]);
                res = Math.max(i-start+1, res);
                map.put(prefix[i+1], i);
            }
        }
        return res;
    }

    private int getBitmap(int prefix, char charAt) {
        switch (charAt){
            case 'a':
                return prefix ^ 1;
            case 'e':
                return prefix ^ 2;
            case 'i':
                return prefix ^ 4;
            case 'o':
                return prefix ^ 8;
            case 'u':
                return prefix ^ 16;
            default: return prefix;
        }
    }
}
