package com.sj0902.sliding;

public class MaxArea {
    public int maxArea(int[] height) {
        int res = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            int curr = (r - l ) * (Math.min(height[l], height[r]));
            if (height[l] < height[r]) {
                ++l;
            } else {
                --r;
            }
            res = Math.max(res, curr);
        }
        return res;
    }
}
