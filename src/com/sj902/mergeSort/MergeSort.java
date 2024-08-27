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
    public void mergeSort(int[] nums) {
        mergeAux(nums, 0, nums.length - 1);
    }

    private void mergeAux(int[] nums, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeAux(nums, start, mid);
            mergeAux(nums, mid + 1, end);
            merge(nums, start, mid, end);
        }
    }

    private void merge(int[] nums, int start, int mid, int end) {
        int a1[] = new int[mid-start+1];
        int a2[] = new int[end-mid];

        for(int i=start;i<=mid;i++){
            a1[i-start] = nums[i];
        }

        for(int i=mid+1;i<=end;i++){
            a2[i-mid-1] = nums[i];
        }
        int[] res = new int[end-start+1];
        int i = 0;
        int j = 0;
        int k = start;

        while(i<a1.length && j<a2.length) {
            if(a1[i]<=a2[j]) nums[k++] = a1[i++];
            else nums[k++] = a2[j++];
        }

        while(i<a1.length) nums[k++] = a1[i++];
        while(j<a2.length) nums[k++] = a2[j++];
    }
}
