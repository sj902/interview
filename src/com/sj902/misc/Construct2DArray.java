package com.sj902.misc;

import java.util.Arrays;

public class Construct2DArray {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int[][] res = new int[m][n];
        int idx = 0;
        for (int i = 0; i < m; ++i) {
            res[i] = Arrays.copyOfRange(original, idx, idx + n - 1);
            idx = idx + n;
        }
        return res;
    }
}
