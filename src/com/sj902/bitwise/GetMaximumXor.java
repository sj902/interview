package com.sj902.bitwise;

public class GetMaximumXor {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int[] xors = new int[nums.length];
        xors[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            xors[i] = nums[i] ^ xors[i-1];
        }

        int max = (int)(Math.pow(2, maximumBit) - 1);
        int[] res = new int[nums.length];
        for (int i = nums.length-1; i >=0 ; i--) {
            res[i] = xors[i] ^ max;
        }

        return res;
    }
}
