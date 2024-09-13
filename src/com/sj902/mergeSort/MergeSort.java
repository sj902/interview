package com.sj902.mergeSort;

import java.util.Arrays;

class S {
    public static void main(String[] args) {
        int[] n = new int[]{9, 11, 2, 12, 5, 6};
        new MergeSort().mergeSort(n);
        System.out.println(Arrays.toString(n));
    }
}

public class MergeSort {
    int[] temp;

    public void mergeSort(int[] nums) {
        temp = new int[nums.length];
        mergeAux(nums, 0, nums.length - 1);
    }

    private void mergeAux(int[] nums, int start, int end) {
        if (start < end) {
            int mid = start + ((end - start) / 2);
            mergeAux(nums, start, mid);
            mergeAux(nums, mid + 1, end);
            merge(nums, start, mid, end);
        }
    }

    private void merge(int[] nums, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            temp[i] = nums[i];
        }

        int i = start;
        int j = mid+1;
        int p = start;
        while (i <= mid && j <= end) {
            if (nums[i] < nums[j]) {
                temp[p++] = nums[i++];
            } else {
                temp[p++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[p++] = nums[i++];
        }
        while (j <= end) {
            temp[p++] = nums[j++];
        }

        for (i = start; i <= end; i++) {
            nums[i] = temp[i];
        }
    }


}
