package com.sj902.binarySearch;

public class FindMinRotated {
    public int findMin(int[] nums) {
        if(nums.length == 1)return nums[0];
        if(nums.length == 2)return Math.min(nums[0], nums[1]);
        int res = nums[0];
        int l = 0;
        int h = nums.length-1;
        while (l<h){
            int mid = l+((h-l)/2);
            if(nums[l]<nums[h])return nums[l];
            if(nums[l]<nums[mid]) l = mid;
            else h = mid;
        }
        return res;
    }
}
