package com.sj902.arrays;

public class PickFromBothSides {
    public int solve(int[] A, int B) {
        int res = -1;
        int sum = 0;
        int  n = A.length;
        for (int i = 0; i < B; i++) {
            sum = sum + A[i];
        }
        res = sum;

        int l = n-1;
        int r = B-1;
        while (r>=0){
            sum = sum + A[l];
            sum = sum - A[r];
            --l;
            --r;
            res = Math.max(sum, res);
        }
        return res;
    }
}
