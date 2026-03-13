package com.sj0902.dp;

import java.util.Arrays;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int q = 0;
        int[][] res = new int[matrix.length][matrix[0].length];
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                if (matrix[i][j] == '0') {
                    res[i][j] = 0;
                } else if (i == matrix.length - 1 || j == matrix[0].length - 1) {
                    res[i][j] = 1;
                } else {
                    int r = res[i + 1][j];
                    int b = res[i][j + 1];
                    int rb = res[i + 1][j + 1];
                    res[i][j] = 1 + Math.min(r, Math.min(b, rb));
                    q = Math.max(q, res[i][j]);
                }
            }
        }
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
        return q*q;
    }
}
