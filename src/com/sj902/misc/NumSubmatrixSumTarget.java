package com.sj902.misc;

import java.util.HashMap;

public class NumSubmatrixSumTarget {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] prefix = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    prefix[i][j] = 0;
                } else {
                    prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1] + matrix[i][j];
                }
            }
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int r1 = 0; r1 <= m; r1++) {
            for (int r2 = r1 + 1; r2 <= m; r2++) {
                map.clear();
                map.put(0,1);
                for (int c = 1; c <=n ; c++) {
                    int currSum = prefix[r2][c] - prefix[r1][0];
                    int diff = target-currSum;
                    res = res + map.getOrDefault(diff, 0);
                    map.put(currSum, map.getOrDefault(currSum,0));
                }
            }
        }
        return res;
    }
}
