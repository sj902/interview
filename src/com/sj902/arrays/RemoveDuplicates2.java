package com.sj902.arrays;

public class RemoveDuplicates2 {
    //Input: nums = [1,1,1,2,2,3]
    //Output: 5, nums = [1,1,2,2,3,_]
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int largest = nums[0];
        int l = 1;
        int r = 1;
        int largestCount = 1;


        while (l < n && r < n) {
            if (nums[l] == largest && largestCount<2) {
                ++largestCount;
                ++l;
            } else if(nums[l] == largest && largestCount>=2){

            }

        }
        return 0;
    }
}
