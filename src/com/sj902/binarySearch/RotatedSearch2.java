package com.sj902.binarySearch;

public class RotatedSearch2 {
    public boolean search(int[] nums, int target) {
        int l = 0;
        int h  = nums.length-1;
        while (l<=h){
            int mid = l + ((h-l)/2);
            if(nums[mid] == target) return true;
            if(nums[l] < nums[mid]){
                if(target>=nums[l] && target<nums[mid]){
                    l = mid+1;
                } else h = mid-1;
            }else if(nums[mid]>nums[h]){
                if(nums[h]>=target && target>nums[mid]){
                    h = mid-1;
                } else l = mid+1;
            }
        }
        return false;
    }
}
