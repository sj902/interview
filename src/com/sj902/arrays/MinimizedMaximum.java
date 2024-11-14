package com.sj902.arrays;

public class MinimizedMaximum {
    public int minimizedMaximum(int n, int[] quantities) {
        int hi = 0;
        for (int a : quantities) {
            hi = Math.max(hi, a);
        }

        int lo = 1;
        int res = hi;

        while (hi >= lo) {
            int mid = lo + ((hi - lo) / 2);
            if (satisfies(n, quantities, mid)) {
                hi = mid - 1;
                res = mid;
            } else {
                lo = mid + 1;
            }
        }
        return res;
    }

    private boolean satisfies(int n, int[] quantities, int mid) {
        int idx = 0;
        int count = 0;
        while (idx < quantities.length) {
            count = count + (int)Math.ceil(quantities[idx] / mid);
            ++idx;

        }
        return count >= n;
    }
}
