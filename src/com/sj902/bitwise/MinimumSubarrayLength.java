package com.sj902.bitwise;

public class MinimumSubarrayLength {
    public int minimumSubarrayLength(int[] nums, int k) {
        int[] bits = new int[32];
        int i = 0;
        int j = 0;
        int res = Integer.MAX_VALUE;
        while (j < nums.length) {
            insert(bits, nums[j]);
            ++j;
            int val = get(bits);
            while (val >= k) {
                res = Math.min(res, j - i + 1);
                remove(bits, nums[i]);
                val = get(bits);
                ++i;
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private void remove(int[] bits, int num) {
        for (int i = 0; i < 32; i++) {
            int bit = num >> i & 1;
            if (bit == 1 && bits[i] > 0) {
                bits[i] = bits[i] - 1;
            }
        }
    }

    private int get(int[] bits) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (bits[i] > 0) {
                res = res + (int) Math.pow(2, i);
            }
        }
        return res;
    }

    private void insert(int[] bits, int j) {
        for (int i = 0; i < 32; i++) {
            int bit = j >> i & 1;
            if (bit == 1) {
                bits[i] = bits[i] + 1;
            }
        }
    }
}
