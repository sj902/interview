package com.sj902.arrays;

public class KthLargest {
    public static void main(String[] args) {
        System.out.println();
    }

    public static void kthLargestAux(int[] arr, int k, int start, int end) {
        int pivot = partition(arr, start, end);
        if (pivot == k - 1) return;
        else if (pivot > k - 1) {
            kthLargestAux(arr, k, start, pivot - 1);
        } else {
            kthLargestAux(arr, k, pivot + 1, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start + 1;
        int j = end;
        while (i <= j) {
            while (i <= end && arr[i] <= pivot) ++i;
            while (j >= start && arr[j] > pivot) --j;
            if (i < j) {
                swap(arr,i,j);
            }
        }
        swap(arr, start,j);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
