package com.sj902.mergeSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class P {
    int idx;
    int val;
    int res;

    public P(int idx, int val, int res) {
        this.idx = idx;
        this.val = val;
        this.res = res;
    }
}


class CountSmaller {
    P[] temp;

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        P[] arr = new P[nums.length];
        temp = new P[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new P(i, nums[i], 0);
        }
        mergeSort(arr, 0, n - 1);
        Integer[] result = new Integer[n];
        for (P p : arr) {
            result[p.idx] = p.res;
        }
        return Arrays.asList(result);
    }

    private void mergeSort(P[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    private void merge(P[] arr, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            temp[i] = arr[i];
        }
        int i = start;
        int j = mid + 1;
        int k = start;
        while (i <= mid && j <= end) {
            if (arr[i].val > arr[j].val) {
                temp[k] = arr[i];
                temp[k].res += end - j + 1;
                ++k;
                ++i;
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        for (int l = start; l <= end; l++) {
            arr[l] = temp[l];
        }
    }
}