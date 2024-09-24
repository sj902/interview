package com.sj902.misc;

public class FindKthNumber {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        int i = 1;
        while (i < k) {
            int count = getCount(curr, n);
            if (i + count < k) {
                ++curr;
                i = i + count;
            } else {
                curr = curr * 10;
                ++i;
            }
        }
        return curr;
    }

    private int getCount(int curr, int n) {
        int res = 0;
        int neighbour = curr + 1;
        while (curr <= n) {
            res += Math.min(neighbour, n + 1) - curr;
            neighbour *= 10;
            curr *= 10;

        }
        return res;
    }
}
