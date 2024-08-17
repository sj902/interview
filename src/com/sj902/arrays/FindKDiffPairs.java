package com.sj902.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class FindKDiffPairs {
    public int findPairs(int[] nums, int k) {
        int res = 0;
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (int i : map.keySet()) {
            if (k == 0) {
                if (map.get(i) >= 2) res++;
            } else {
                int diff = k - i;
                if (map.containsKey(diff))++res;
            }
        }

        return res;
    }
}
