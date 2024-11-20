package com.sj902.sliding;

import java.util.HashMap;

public class TakeCharacters {
    public int takeCharacters(String s, int k) {
        int[] map = new int[3];
        int n = s.length();

        for (int i = 0; i < n; i++) {
            map[s.charAt(i)-'a']++;
        }

        if (map[0] < k || map[1] < k || map[2] < k) {
            return -1;
        }


        int left = 0;


        int res = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            map[s.charAt(right)-'a']--;
            while (!isValid(map, k)) {
                map[s.charAt(left)-'a']++;
                ++left;
            }
            res = Math.min(res, n - (right - left + 1));
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }


    private boolean isValid(int[] total, int k) {
        return total[0] >= k &&
                total[1] >= k &&
                total[2] >= k;
    }
}
