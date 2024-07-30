package com.sj902.arrays;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for(int e: nums){
            if(e!=val){
                nums[i] = e;
                ++i;
            }
        }
        return i;
    }
}
