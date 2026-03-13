package com.sj902.sliding;

import java.util.HashMap;

public class MaximumSubarraySumOfLenK {
    public long maximumSubarraySum(int[] nums, int k) {
        long res = 0;
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        long currSum = 0;
        int invalidCount = 0;

        while (i < n) {
            int curr = nums[i];
            map.put(curr, map.getOrDefault(curr, 0) + 1);
            currSum += curr;
            if (map.get(curr) > 1) {
                ++invalidCount;
            }
            if (i == k - 1) {
                if (invalidCount == 0) {
                    res = Math.max(res, currSum);
                }
            } else if (i >= k) {
                int prev = nums[i - k];
                map.put(prev, map.get(prev) - 1);
                if (map.get(prev) >= 1) --invalidCount;
                currSum = currSum - prev;
                if (invalidCount == 0) {
                    res = Math.max(res, currSum);
                }
            }
            ++i;
        }
        return res;
    }
}
