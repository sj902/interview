package com.sj902.sliding;

import java.util.HashMap;

public class NumberOfSubstrings {
    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("ababbbc"));
    }

    public static int numberOfSubstrings(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int begin = 0;
        int end = 0;
        int res = 0;

        while (end < s.length()) {
            char c = s.charAt(end);
            map.put(c, end);

            ++end;

            if (map.size() == 3) {
                int newBegin = Math.min(map.get('a'), Math.min(map.get('c'), map.get('b')));
                res = res + newBegin - begin+1;
            }
        }
        return res;
    }
}
