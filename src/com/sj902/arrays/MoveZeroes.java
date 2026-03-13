package com.sj902.arrays;

public class MoveZeroes {
    public void moveZeroes(int[] nums){
        int n = nums.length;

        int l = -1;
        int r = -1;
        for (int i = 0; i < n; i++) {
            if(nums[i] == 0){
                r = i;
                break;
            }
        }

        if(r == -1) return;

        for (int i = r+1; i < n; i++) {
            if(nums[i] != 0){
                l = i;
                break;
            }
        }
        if(l == -1) return;

        int i = r+1;

        while(i<n && r<n){
            if(nums[i]!=0){
                nums[r] = nums[i];
                nums[i] = 0;
                while(r<n && nums[r]!=0)++r;
            }
            ++i;
        }
    }

}
