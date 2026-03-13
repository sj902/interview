package com.sj902.dp;

import java.util.HashSet;

public class CanPartitionKSubsets {
    int[] sides;
    int target;
    int[] arr;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        arr = nums;
        sides = new int[k];
        int sum = 0;
        for (int p : nums) sum += p;
        if (sum % k != 0) return false;
        target = sum / k;
        return aux(0);
    }

    private boolean aux(int idx) {
        if (idx == arr.length) return true;
        for (int i = 0; i < sides.length; i++) {
            if (sides[i] + arr[idx] <= target) {
                sides[i] += arr[idx];
                if (aux(idx + 1)) return true;
                sides[i] -= arr[idx];
            }
        }
        return false;
    }
}
