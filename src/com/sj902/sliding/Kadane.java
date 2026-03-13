package com.sj902.sliding;

public class Kadane {
    public static int kadane(int[] arr, int k) {
        int l = 0;
        int s = 0;
        int r = 0;

        while (r < k) {
            s = s + arr[r];
            ++r;
        }

        while (r < arr.length) {
            ++r;
            ++l;
            int newS = s - arr[l - 1] + arr[r + 1];
            s = Math.max(newS, s);
        }
        return s;
    }

}
