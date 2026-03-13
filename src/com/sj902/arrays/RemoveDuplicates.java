package com.sj902.arrays;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int largest = nums[0];
        int n = nums.length;
        int l = 1;
        int r = 1;


        while(l<n && r<n){
            if(nums[r]>largest){
                int t = nums[l];
                nums[l] =nums[r];
                nums[r] = t;
                ++l;
                ++r;
            }else{
                ++r;
            }
        }
        return l;
    }
}
