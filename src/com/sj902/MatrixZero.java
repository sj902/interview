package com.sj902;

import java.util.ArrayList;
import java.util.HashSet;

public class MatrixZero {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        HashSet<Integer> rowZero = new HashSet<>();
        HashSet<Integer> colZero = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    rowZero.add(i);
                    colZero.add(j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(rowZero.contains(i) || colZero.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
    }

}
