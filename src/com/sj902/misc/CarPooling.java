package com.sj902.misc;

import java.util.Arrays;

public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b)-> a[2]-b[2]);
        int[] arr = new int[trips[trips.length-1][2]];
        for (int[] p: trips) {
            arr[p[1]]+=p[0];
            arr[p[2]]-=p[0];
        }
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        if(prefix[0]>capacity)return false;
        for(int i = 1; i<arr.length;++i){
            prefix[i] = prefix[i-1]+arr[i];
            if(prefix[i]>capacity)return false;
        }
        return true;
     }
}
