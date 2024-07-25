package com.sj902.arrays;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] a) {
        int prod = 1;
        int n = a.length;
        int zeroCount = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] != 0) {
                ++zeroCount;
                prod = prod * a[i];
            }
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if(zeroCount>=2){
                res[i] = 0;
            } else if(a[i]==0){
                res[i] = prod;
            } else {
                res[i] = prod/a[i];
            }
        }
        return res;
    }
}
