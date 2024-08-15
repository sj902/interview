package com.sj902;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralOrder {
    public static void main(String[] args) {
    }

    public List<Integer> spiralOrder(final int[][] A) {

        int m = A.length;
        int n = A[0].length;
        int r1 = 0;
        int c1 = 0;
        int r2 = m - 1;
        int c2 = n - 1;

        List<Integer> res = new ArrayList<>();
        while (r2>=r1 && c2>=c1){
            for (int i = c1; i <=c2 ; i++) {
                res.add(A[r1][i]);
            }
            ++r1;
            if(r2>r1)break;
            for (int i = r1; i <=r2 ; i++) {
                res.add(A[i][c2]);
            }
            --c2;
            if (c1 > c2) break;
            for (int i = c2; i >=c1 ; i--) {
                res.add(A[r2][i]);
            }
            --r2;
            if (r1 > r2) break;
            for (int i = r2; i >=r1 ; i--) {
                res.add(A[i][c1]);
            }
            ++c1;
        }
        return res;
    }
}
