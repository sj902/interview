package com.sj902.dp;

import java.util.HashSet;

public class CanPartitionKSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int p : nums) sum += p;
        if (sum % 4 != 0) return false;
        return aux(nums, k, new HashSet<Integer>(), sum/4, 0, 0);
    }

    private boolean aux(int[] nums, int k, HashSet<Integer> used, int target, int index, int curr) {
        if (k == 0) return true;
        if(curr == target){
            aux(nums, k-1, used, target, 0 ,0);
        }
        for (int i = index; i < nums.length; i++) {
            if (used.contains(i) || curr + nums[i] > target) continue;

            used.add(i);
            if (aux(nums, k, used,target, i+1,curr + nums[i])) {
                return true;
            }
            used.remove(i);
        }
        return false;
    }
}
