package com.sj902.arrays;

import java.util.HashMap;
import java.util.HashSet;

public class CheckSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        int prefix = nums[0]%k;
        HashMap<Integer, Integer> set =  new HashMap<>();
        for (int i = 1; i < nums.length; i++) {
            prefix = (prefix+ nums[i]) % k;
            if(prefix == 0 && i>1) return true;
            if(set.containsKey(prefix) && set.get(prefix)<i-2) return true;
            if(!set.containsKey(prefix)){
                set.put(prefix, i);
            }
        }
        return false;
    }
}
