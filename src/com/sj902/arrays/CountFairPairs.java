package com.sj902.arrays;

import java.util.Arrays;
import java.util.TreeMap;

class Sol {
    public static void main(String[] args) {
        System.out.println(new CountFairPairs().countFairPairs(new int[]{0,1,7,4,4,5}, 3,6));
    }
}

public class CountFairPairs {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);

        System.out.println(Arrays.toString(nums));

        TreeMap<Integer, Integer> high = new TreeMap<>();
        TreeMap<Integer, Integer> low = new TreeMap<>();

        int min = nums[0];
        int max = nums[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            high.put(nums[i], i);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            low.put(nums[i], i);
        }

        long res = 0;

        for (int i = 0; i < nums.length; i++) {
            long k = getCount(i, nums[i], lower, upper, low, high, nums.length, min, max);
            System.out.println(nums[i] + "::" + k);
            res = res + k;
        }
        return res / 2;
    }

    private long getCount(int i, int num, int lower, int upper, TreeMap<Integer, Integer> low, TreeMap<Integer, Integer> high, int len, int min, int max) {
        if (num + min > upper || num + max < lower) {
            return 0;
        }


        int lowerElem = lower - num;
        int lowerIdx = len-1;
        if (low.ceilingKey(lowerElem) != null) {
            lowerIdx = low.get(low.ceilingKey(lowerElem));
        }

        int higherElem = upper - num;
        int higherIdx = 0;
        if (high.floorKey(higherElem) != null) {
            higherIdx = high.get(high.floorKey(higherElem));
        }

        int count = higherIdx - lowerIdx;
        System.out.println(num + "::" + lowerElem + "::" + lowerIdx + ":--:" + higherElem + ":--:" + higherIdx + "::" + count + "::");

        if (count < 0) {
            return 0;
        }

        if (lowerIdx <= i && higherIdx >= i) {
            return count;
        }
        return count + 1;
    }
}
