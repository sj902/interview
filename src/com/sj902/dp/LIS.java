package com.sj902.dp;

import java.util.Arrays;
import java.util.TreeMap;

public class LIS {
    int[] res;
    public int lengthOfLIS(int[] a) {
        res = new int[a.length];
        Arrays.fill(res,-1);
        int maxLength = 1;
        for (int i = 0; i < a.length; i++) {
            maxLength = Math.max(maxLength, lengthOfLISAux(a, i));
        }

        return maxLength;
    }

    private int lengthOfLISAux(int[] a, int idx) {
        if(idx<0) return 0;
        if(idx == 0) return 1;
        if(res[idx]!=-1)return res[idx];
        int r = 1;
        for (int i = idx-1; i >=0 ; i--) {
            if(a[i]<a[idx]){
                r = Math.max(r, lengthOfLISAux(a, i)+1);
            }
        }
        return res[idx]=r;
    }
}
