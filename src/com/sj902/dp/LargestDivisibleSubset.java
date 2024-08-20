package com.sj902.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer>[] res = new List[nums.length];

        for (int i = 0; i < nums.length; i++) {
            res[i] = new ArrayList<>();
            res[i].add(nums[i]);
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && res[j].size() + 1 > res[i].size()) {
                    res[i] = new ArrayList<>(res[j]);
                    res[i].add(nums[i]);
                }
            }
        }
        int maxIdx = 0;
        for (int i = 0; i < res.length; i++) {
            if(res[i].size()>res[maxIdx].size()){
                maxIdx = i;
            }
        }
        return res[maxIdx];
    }
}
