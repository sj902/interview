package com.sj902;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralOrder {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(spiralOrder(new int[][]{{1,2},{3,4},{5,6}})));
    }

    public static int[] spiralOrder(final int[][] A) {

        int n = A.length;
        int m = A[0].length;
        int t = 0;
        int l = 0;
        int r = m - 1;
        int b = n - 1;

        List<Integer> res = new ArrayList<>();
        while (t <= b && l <= r) {
            int i = 0;
            i = l;
            while (i <= r) {
                res.add(A[t][i]);
                ++i;
            }
            ++t;

            i = t;
            while (i <= b) {
                res.add(A[i][r]);
                ++i;
            }
            --r;


            i = r;
            while (i >= l) {
                res.add(A[b][i]);
                --i;
            }
            --b;


            i = b;
            while (i >= t) {
                res.add(A[i][l]);
                --i;
            }
            ++l;
        }
        int[] a = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            a[i] = res.get(i);
        }
        return a;
    }
}
