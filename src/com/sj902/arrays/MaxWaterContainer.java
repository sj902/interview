package com.sj902.arrays;

public class MaxWaterContainer {
    public int maxArea(int[] a) {
        int n = a.length;
        int l = 0;
        int r = n-1;
        int max = Integer.MIN_VALUE;
        while (l<r){
            int left = a[l];
            int right = a[r];
            int dist = r-l;
            int area = dist * Math.min(left, right);
            max = Math.max(area, max);
            if(left<right){
                ++l;
            } else {
                --r;
            }
        }
        return max;
    }
}
