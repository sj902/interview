package com.sj902.arrays;

public class IsZeroArray2 {

    public int minZeroArray(int[] nums, int[][] queries) {
        int hi = queries.length-1;
        int lo = 0;
        int res = Integer.MAX_VALUE;

        if (isZeroArray(nums, queries, -1)) return 0;


        while (hi >= lo) {
            int mid = ((hi + lo) / 2);

            if (isZeroArray(nums, queries, mid)) {
                res = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }


        return res == Integer.MAX_VALUE ? -1 : res;

    }


    public boolean isZeroArray(int[] nums, int[][] queries, int mid) {
        int[] line = new int[nums.length + 1];

        for (int i = 0; i < mid; i++) {
            int[] a = queries[i];
            line[a[0]] = line[a[0]] + a[2];
            line[a[1]] = line[a[1]+1] - a[2];
        }

        int[] prefix = new int[nums.length + 1];
        prefix[0] = line[0];
        if (prefix[0] < nums[0]) return false;

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + line[i];
            if (prefix[i] < nums[i]) return false;
        }

        return true;
    }
}
