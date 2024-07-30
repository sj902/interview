package com.sj902.arrays;

import java.util.Arrays;

public class NumArray {

    int[] segmentTree;
    int n;

    void buildTree(int l, int r, int[] nums, int idx) {
        if (l == r) {
            segmentTree[idx] = nums[l];
            return;
        }
        if (l < 0 || r < 0 || r >= nums.length || l > r) return;
        int mid = (l + r) / 2;
        buildTree(l, mid, nums, (2 * idx) + 1);
        buildTree(mid + 1, r, nums, (2 * idx) + 2);
        segmentTree[idx] = segmentTree[(2 * idx) + 1] + segmentTree[(2 * idx) + 2];
    }

    public NumArray(int[] nums) {
        n = nums.length;
        segmentTree = new int[nums.length * 4];
        buildTree(0, nums.length - 1, nums, 0);
    }

    public int sumRange(int left, int right) {
        return sumRangeAux(left, right, 0, 0, n - 1);
    }

    private int sumRangeAux(int l, int r, int i, int s, int e) {
        if (s > r || e < l) return 0;

        if (s >= l && e <= r) return segmentTree[i];
        int mid = (s + e) / 2;
        return sumRangeAux(l, r, ((2 * i) + 1), s, mid) + sumRangeAux(l, r, ((2 * i) + 2), mid + 1, e);
    }
}

class Main {
    public static void main(String[] args) {
        NumArray a = new NumArray(new int[]{1, 2, 3, 4, 5});
        System.out.println(Arrays.toString(a.segmentTree));
        System.out.println(a.sumRange(1, 3));
    }
}