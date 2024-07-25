package com.sj902.dp;

import java.util.Arrays;

public class LIS {
    public int lengthOfLIS(int[] a) {
        int n = a.length;
        int[] res = new int[a.length];
        Arrays.fill(res, 1);
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j]) {
                    max = Math.max(max, res[j]);
                }
            }
            res[i] = max + 1;
        }
        int m = 0;
        for (int i = 0; i < n; i++) {
            m = Math.max(m, res[i]);
        }
        return m;
    }
}
