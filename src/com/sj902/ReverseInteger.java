package com.sj902;

public class ReverseInteger {
    public int reverse(int x) {
        if(x == Integer.MIN_VALUE) return 0;
        boolean isNeg = x<0;
        x = Math.abs(x);
        int k = x;
        int i = 0;
        while (k>=0){
            int m=k%10;
            i = (i *10)+m;
            k = k/10;
        }
        if(isNeg) return -1*i;
        return i;
    }
}
