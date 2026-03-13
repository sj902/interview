package com.sj902.arrays;

import java.util.Arrays;

public class MaxNonNegativeSubArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxset(new int[]{1967513926, 1540383426, -1303455736, -521595368})));
    }

    public static int[] maxset(int[] A) {
        int maxL = 0;
        int maxR = 0;
        long maxSum = -1;
        int l = 0;
        int r = 0;
        long currSum = 0;
        int n = A.length;


        for (int i = 0; i < n; i++) {
            if (A[i] < 0) {
                l = i + 1;
                currSum = 0;
            } else {
                currSum = currSum + A[i];
                System.out.println(currSum + "::" + maxSum);

                if (currSum > maxSum) {
                    maxSum = currSum;
                    maxL = l;
                    maxR = i;
                } else if (currSum == maxSum && maxR - maxL < i - l) {
                    maxL = l;
                    maxR = i;
                }
            }
        }
        if (maxSum < 0) return new int[]{};
        int[] res = new int[maxR - maxL + 1];
        System.out.println(maxL + "::" + maxR);
        for (int i = maxL; i < maxR + 1; i++) {
            res[i - maxL] = A[i];
        }
        return res;
    }
}
