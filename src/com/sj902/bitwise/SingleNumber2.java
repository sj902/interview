package com.sj902.bitwise;

public class SingleNumber2 {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int k = 0; k < 31; k++) {
            int q = 0;
            for (int j = 0; j < n; j++) {
                q += nums[j] >> k & 1;
                q = q % 3;
                if (q > 0) {
                    res = res | q<<k;
                }
            }
        }

        return res;
    }
}
