package com.sj902.arrays;

import java.util.HashMap;
import java.util.HashSet;

public class LongestConsecutive {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{1,0,-1}));
    }

    public static int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            map.put(nums[i], 1);
        }
        int max = 0;

        for (int i : nums) {
            if (map.containsKey(i)) {
                int q = 1;
                int k = map.get(i);
                while (map.containsKey(i + q)) {
                    System.out.println(i+"\t"+ (i+q));
                    k = map.get(i) + map.get(i+q);
                    map.put(i, map.get(i) + 1);
                    map.remove(i + q);
                    ++q;
                }
                max = Math.max(k, max);
            }
        }
        return max;
    }
}
