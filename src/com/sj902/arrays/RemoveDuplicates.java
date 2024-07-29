package com.sj902.arrays;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int largest = nums[0];
        int n =  nums.length;
        int r = 1;
        int l = 1;

        while(l<n && r<n){
            if(nums[r]>largest){
                int t = nums[r];
                largest = nums[r];
                nums[l] = nums[r];
                nums[r] = t;
                ++l;
                ++r;
            } else {
                ++r;
            }
        }
        return l;
    }
}
