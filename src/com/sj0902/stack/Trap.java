package com.sj0902.stack;

import java.util.Arrays;
import java.util.Stack;

class Sol3254 {
    public static void main(String[] args) {
        System.out.println(new Trap().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}

public class Trap {

    public int trap(int[] height) {
        int[] right = rightLarger(height);
        int[] left = leftLarger(height);

        int res = 0;
        int n = height.length;
        for (int i = 0; i < n; i++) {
            int leftLarge = left[i];
            int rightLarge = right[i];
            res = res + Math.max(0, Math.min(leftLarge, rightLarge) - height[i]);
        }
        return res;
    }

    int[] rightLarger(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        int max = 0;

        for (int i = n - 1; i >= 0; i--) {
            res[i] = max;
            max = Math.max(max, arr[i]);
        }
        return res;
    }

    int[] leftLarger(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            res[i] = max;
            max = Math.max(max, arr[i]);
        }
        return res;
    }
}
