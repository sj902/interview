package com.sj902.arrays;

public class DefuseTheBomb {
    public int[] decrypt(int[] code, int k) {
        if (k == 0) return new int[code.length];
        int n = code.length;
        int[] res = new int[n];
        int sum = 0;

        if (k > 0) {
            for (int i = 1; i <= k; i++) {
                sum += code[i];
            }
            res[0] = sum;
            for (int i = 1; i < n; i++) {
                res[i] = res[i - 1] - code[i] + code[(k + i) % n];
            }
        } else {
            k = -1 * k;
            for (int i = n - 2; i >= n - k - 1; i--) {
                sum += code[i];
            }
            res[n - 1] = sum;
            for (int i = n - 2; i >= 0; i--) {
                res[i] = res[i + 1] - code[i] + code[(n + i - k) % n];
            }
        }
        return res;
    }
}
