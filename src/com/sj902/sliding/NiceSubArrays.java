package com.sj902.sliding;

import java.util.HashMap;

public class NiceSubArrays {
    public static void main(String[] args) {
        System.out.println(numberOfSubarrays(new int[]{1,1,2,1,1}, 3));
    }

    public static int numberOfSubarrays(int[] s, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length; i++) {
            s[i] = s[i] % 2;
        }
        map.put(0, 0);
        map.put(1, 0);

        int begin = 0;
        int end = 0;
        int counter = 0;
        int res = 0;
        while (end < s.length) {
            int c = s[end];
            map.put(c, map.get(c) + 1);
            if (c == 1) counter++;
            ++end;
            while (counter > k && begin < s.length) {
                int q = s[begin];
                if (q == 1) {
                    map.put(q, map.get(q) - 1);
                    counter--;
                }
                begin++;
            }
            if(counter == k){
                for (int i = begin; i < end && s[i] == 0; i++) {
                    res = res + 1;
                }
                res ++;
            }

        }
        return res;
    }
}
