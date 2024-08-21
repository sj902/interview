package com.sj902.misc;

import java.util.HashMap;

public class RomanToInt {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);


        int res = 0;
        int prevMax = 0;
        for (int i = s.length()-1; i >=0; i--) {
            char c = s.charAt(i);
            int k = map.get(c);
            if(k<prevMax) {
                res = res - k;
            } else {
                res +=k;
            }
            prevMax = Math.max(prevMax, k);
        }
        return res;
    }
}
