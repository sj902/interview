package com.sj902.bitwise;

public class HammingWeight {
    public int hammingWeight(int n) {
        int sum = 0;
        while (n>0){
            if((n&1) >0){
                sum++;
            }
            n = n>>1;
        }
        return sum;
    }
}
