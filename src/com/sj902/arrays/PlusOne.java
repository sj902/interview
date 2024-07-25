package com.sj902.arrays;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{0})));
    }

    public static int[] plusOne(int[] A) {
        int n = A.length;
        int[] res = new int[A.length+1];
        int carry = 1;
        for (int i = n; i >0 ; i--) {
            int s = A[i-1]+carry;
            res[i] = (s)%10;
            carry = s/10;
        }
        if(carry == 1){
            res[0] = 1;
            return res;
        }
        int y = 0;
        while(res[y]==0)++y;
        return Arrays.copyOfRange(res, y, res.length);
    }
}
