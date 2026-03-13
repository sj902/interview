package com.sj902.arrays;

public class MinimumLightstoActivate {

    public int solve(int[] arr, int power) {
        int n = arr.length;
        int res = 0;
        int i = 0;
        while (i < n) {
            int end = Math.min(n-1,i + power - 1);
            int pos = -1;
            while (end > i) {
                if (arr[end] == 1) {
                    pos = end;
                    break;
                }
                --end;
            }
            if (pos == -1) {
                return -1;
            } else {
                ++res;
                i = pos + power;
            }
        }
        return res;
    }
}
