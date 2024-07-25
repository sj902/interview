package com.sj902.arrays;

public class MinStepsInfiniteGrid {
    public int coverPoints(int[] A, int[] B) {
        int res= 0;
        for (int i = 1; i < A.length; i++) {
            res = res + getDist(A[i-1],B[i-1],A[i],B[i]);
        }
        return res;
    }

    private int getDist(int x1, int y1, int x2, int y2) {
        return Math.max(Math.abs(x1-x2), Math.abs(y1-y2));
    }
}
