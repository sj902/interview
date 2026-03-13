package com.sj902.arrays;

import java.util.Arrays;

public class HIndex {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int k = 5002;
        int res = 0;
        int[] suffix = new int[k];
        int[] count = new int[k];
        Arrays.fill(count, 0);
        for (int i = 0; i < n; i++) {
            count[citations[i]]++;
        }
        suffix[5001] = 0;
        for (int i = 5000; i >=0; i--) {
            suffix[i] = suffix[i+1]+citations[i];
        }
        for (int i = 5000; i >=0; i--){
            if(suffix[i]>=i)return i;
        }
        return 0;
    }
}
