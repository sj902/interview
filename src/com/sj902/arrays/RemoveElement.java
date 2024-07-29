package com.sj902.arrays;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int l = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(nums[l] == val) {
                l = i;
                break;
            }
        }


        int r = n-1;
        while(r<=0){
            if(nums[r]!=val){
                break;
            }
            --r;
        }

        int res = 0;

        while(l<r){
            if(nums[l]==val){
                int t = nums[r];
                nums[r] = nums[l];
                nums[l] = t;
                while(r>=0 && l<r && nums[r]==val)--r;
                ++l;
                ++res;
            } else{
                ++l;
            }
        }
        return res;
    }
}
