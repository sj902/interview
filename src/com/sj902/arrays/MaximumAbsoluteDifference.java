package com.sj902.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MaximumAbsoluteDifference {
    public int maxArr(int[] arr) {
        int n = arr.length;
        int[] diff = new int[n];
        int[] sum = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = arr[i]-i;
            sum[i] = arr[i]+i;
        }
        Arrays.sort(diff);
        Arrays.sort(sum);
        return Math.max(diff[n-1]-diff[0], sum[n-1]-sum[0]);
    }
}
