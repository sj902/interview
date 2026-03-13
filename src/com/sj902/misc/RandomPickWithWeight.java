package com.sj902.misc;

import java.util.Random;

public class RandomPickWithWeight {

}

class Solution1 {

    int[] prefix;
    int sum;

    public Solution1(int[] w) {
        prefix = new int[w.length];
        prefix[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            prefix[i] = prefix[i - 1] + w[i];
        }
        sum = prefix[w.length - 1];
    }

    public int pickIndex() {
        if(prefix.length ==1 ) return 0;
        int rand = new Random().nextInt(sum) + 1;
        int hi = prefix.length-1;
        int lo = 0;
        int res = 0;
        while (lo<=hi) {
            int mid = lo + ((hi-lo)/2);
            if(prefix[mid] == rand){
                res = mid;
                break;
            } else if (prefix[mid]<rand) {
                lo = mid+1;
            } else{
                res = mid;

                hi = mid-1;
            }
        }

        return res;
    }
}

