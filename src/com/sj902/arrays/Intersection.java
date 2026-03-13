package com.sj902.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] res = new int[nums1.length + nums2.length];

        int l = 0;
        int r = 0;
        int i = 0;
        while (l < nums1.length && r < nums2.length) {
            if(nums1[l] == nums2[r]){
                res[i] = nums1[l];
                while(l < nums1.length && nums1[l] == res[i]) ++l;
                while(r < nums2.length && nums2[r] == res[i]) ++r;
                ++i;
            } else if(nums1[l] < nums2[r]){
                ++l;
            } else {
                ++r;
            }
        }
        return Arrays.copyOf(res,i+1);
    }
}
