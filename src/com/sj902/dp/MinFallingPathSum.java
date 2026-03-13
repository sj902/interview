package com.sj902.dp;

public class MinFallingPathSum {
    int[][] mat;

    public int minFallingPathSum(int[][] matrix) {
        mat = matrix;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            res = Math.min(aux(0, i), res);
        }
        return res;
    }

    private int aux(int r, int c) {
        int n = mat.length;
        if(r == n-1 && c>0 && c<n) return mat[r][c];
        if (r >= n || c >= n || c < 0) return 0;
        return mat[r][c] + Math.min(
                aux(r + 1, c - 1),
                Math.min(aux(r + 1, c), aux(r + 1, c + 1))
        );
    }


}
