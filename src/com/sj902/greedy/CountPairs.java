package com.sj902.greedy;

import java.util.HashMap;

class Runner {
    public static void main(String[] args) {
        System.out.println(new CountPairs().countPairs(new int[]{3, 12, 30, 17, 21}));
    }
}

public class CountPairs {
    public int countPairs(int[] nums) {
        int res = 0;
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (isSame(nums[i], nums[j])) {
                    System.out.println(nums[i] + ":::" + nums[j]);
                    ++res;
                }
            }
        }
        return res;
    }

    boolean isSame(int a, int b) {
        if (a == b) return true;
        if (a > b) {
            int t = a;
            a = b;
            b = t;
        }
        String first = a + "";
        String sec = b + "";
        int zeroPadding = sec.length() - first.length();
        for (int i = 0; i < zeroPadding; ++i) {
            first = "0" + first;
        }
        int diff = 0;
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < first.length(); ++i) {
            map1.put(first.charAt(i), map1.getOrDefault(first.charAt(i), 0) + 1);
            map2.put(sec.charAt(i), map2.getOrDefault(sec.charAt(i), 0) + 1);
            if (first.charAt(i) != sec.charAt(i)) {
                ++diff;
            }
        }
        if (diff > 2) return false;
        if (map1.size() != map2.size()) return false;
        for (char c : map1.keySet()) {
            if (!map2.containsKey(c) || map1.get(c).intValue() != map2.get(c).intValue()) return false;
        }
        return true;
    }
}
