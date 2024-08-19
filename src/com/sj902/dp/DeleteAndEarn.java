package com.sj902.dp;

import java.util.Arrays;
import java.util.HashMap;

public class DeleteAndEarn {
    Integer[] res;
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            max = Math.max(max, nums[i]);
        }
        int[] arr = new int[freq.size()];
        int y = 0;
        for (int i = 0; i < max; i++) {
            arr[y++] = i;
        }
        res = new Integer[arr.length];
        Arrays.sort(arr);
        return aux(arr, arr.length-1, freq);
    }

    private int aux(int[] nums, int idx, HashMap<Integer, Integer> map) {
        if (idx == nums.length) return 0;
        if (idx == 0) return nums[0] * map.getOrDefault(nums[0], 0);
        if (idx == 1) return Math.max(nums[0] * map.getOrDefault(nums[0], 0), nums[1] * map.getOrDefault(nums[1], 0));
        if(res[idx]!=null) return res[idx];
        return res[idx] = Math.max(
                nums[idx] * map.getOrDefault(nums[idx], 0) + aux(nums, idx - 2, map),
                aux(nums, idx - 1, map)
        );
    }
}
