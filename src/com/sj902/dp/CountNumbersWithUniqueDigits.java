package com.sj902.dp;

public class CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        int[] res = new int[n+1];
        res[0] = 1;
        res[1] = 10;
        for (int i = 2; i <=n ; i++) {
            int k = i-1;
            int prod = 9;
            int q = 9;
            for (int j = k; j >=0 ; j--) {
                prod = prod*q;
                --q;
            }
            res[i] = res[i-1]+prod;
        }
        return res[n];
    }
}
