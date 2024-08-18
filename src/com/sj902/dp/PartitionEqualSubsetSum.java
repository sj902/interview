package com.sj902.dp;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
    int[][]res;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if(sum%2==1) return false;
        res = new int[nums.length][sum+1];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(res[i],-1);
        }
        return canPartitionAux(nums, sum/2, 0);
    }

    private boolean canPartitionAux(int[] nums, int sum, int idx) {
        if(sum == 0) return true;
        if(sum<0 || idx >= nums.length || idx<0) return false;
        if(res[sum][idx]!=-1) return res[sum][idx]==1;
        boolean k =  canPartitionAux(nums, sum-nums[idx], idx+1) ||
                canPartitionAux(nums, sum, idx+1);
        res[sum][idx]= k?1:0;
        return k;
    }
}
