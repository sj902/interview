package com.sj902.arrays;

import java.util.Arrays;

public class KokoBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        Arrays.sort(piles);
        int low = piles[0];
        int high = piles[n-1];
        int res = high;

        while(low<=high){
            int mid = (high-low)/2;
            if(satisfies(mid,h,piles)){
                res = mid;
                high = mid-1;
            } else{
                low = mid +1;
            }
        }
        return res;
    }

    private boolean satisfies(int mid, int h, int[] piles) {
        int sum = 0;
        for(int y: piles){
            sum = sum+(int)(Math.ceil((double) y/mid));
        }
        return sum<=h;
    }
}
