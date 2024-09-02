package com.sj902.dynamicProgramming;

import java.util.Arrays;

public class MinFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = matrix[0][i];
        }

        for (int i = 1; i < n; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                int a;
                int b;
                int c;
                if (j - 1 < 0) {
                    a = Integer.MAX_VALUE;
                } else {
                    a = res[j - 1];
                }
                b = res[j];
                if (j + 1 >= n) {
                    c = Integer.MAX_VALUE;
                } else {
                    c = res[j + 1];
                }
                int k = Math.min(a, Math.min(b,c));
                temp[j] = matrix[i][j] + k;
            }
            res = temp;
        }
        return Arrays.stream(res).min().getAsInt();
    }

}
