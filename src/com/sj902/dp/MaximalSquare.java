package com.sj902.dp;

import java.util.Arrays;

public class MaximalSquare {
    int[][] res;

    public int maximalSquare(char[][] matrix) {
        int r = 0;
        res = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            Arrays.fill(res[i], -1);
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                r = Math.max(aux(matrix, i, j), r);
            }
        }
        return r*r;
    }

    private int aux(char[][] matrix, int i, int j) {
        if (i == matrix.length - 1 || j == matrix[0].length - 1) {
            if (matrix[i][j] == '1') return 1;
            else return 0;
        }
        if (i >= matrix.length || j >= matrix[0].length || matrix[i][j] == '0') return 0;
        if(res[i][j] !=-1) return res[i][j];
        if (matrix[i + 1][j] == '1' && matrix[i][j + 1] == '1' && matrix[i + 1][j + 1] == '1') {
            return res[i][j] = 1 + Math.min(
                    aux(matrix, i + 1, j),
                    Math.min(
                            aux(matrix, i, j + 1),
                            aux(matrix, i + 1, j + 1)
                    )
            );
        }
        return res[i][j] =1;
    }

}
