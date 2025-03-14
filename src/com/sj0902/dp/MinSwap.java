package com.sj0902.dp;

public class MinSwap {
    int[] a1;
    int[] a2;

    public int minSwap(int[] nums1, int[] nums2) {
        a1 = nums1;
        a2 = nums2;
        return Math.min(
                aux(nums1.length - 1, false),
                1 + aux(nums1.length - 1, true)
        );
    }

    private int aux(int idx, boolean swapped) {
        if (idx <= 0) return 0;

        int newIdx = idx - 1;
        int l1 = a1[newIdx];
        int r1 = a2[newIdx];

        int l, r;
        if (swapped) {
            l = a2[idx];
            r = a1[idx];
        } else {
            l = a1[idx];
            r = a2[idx];
        }


        int swap, notSwap;
        swap = Integer.MAX_VALUE;
        notSwap = Integer.MAX_VALUE;

        if (l > r1 && r > l1) {
            swap = 1 + aux(newIdx, true);
        }
        if (l > l1 && r > r1) {
            notSwap = aux(newIdx, false);
        }
        return Math.min(swap, notSwap);
    }


}
