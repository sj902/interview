package com.sj902.arrays;

public class RemoveDuplicates2 {
    //Input: nums = [1,1,1,2,2,3]
    //Output: 5, nums = [1,1,2,2,3,_]
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int e:nums) {
            if(i == 0 || i == 1 || e!=nums[i-2]){
                ++i;
            }
        }
        return i;
    }
}
