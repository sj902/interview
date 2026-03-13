package com.sj902;

import java.util.ArrayList;
import java.util.List;

public class GenerateSpiralMatrix {
    public int[][] generateMatrix(int n) {
        int r1 = 0;
        int c1 = 0;
        int r2 = n - 1;
        int c2 = n - 1;
        int[][] A = new int[n][n];
        int k = 0;

        while (r2>=r1 && c2>=c1){
            for (int i = c1; i <=c2 ; i++) {
                A[r1][i] = k++;
            }
            ++r1;
            if(r1>r2||c1>c2)break;
            for (int i = r1; i <=r2 ; i++) {
                A[i][c2] = k++;
            }
            --c2;
            if(r1>r2||c1>c2)break;
            for (int i = c2; i >=c1 ; i--) {
                A[r2][i] = k++;
            }
            --r2;
            if(r1>r2||c1>c2)break;
            for (int i = r2; i >=r1 ; i--) {
                A[i][c1] = k++;
            }
            ++c1;
        }
        return A;
    }
}
