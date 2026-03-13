package com.sj902.arrays;

public class FindLengthOfShortestSubarray {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int j = n - 1;

        while (j >= 0 && arr[j - 1] < arr[j]) --j;

        int i = 0;
        int result = 0;

        while (i < j && (i == 0 || arr[i - 1] < arr[i + 1])) {

            while (j < n && arr[i] > arr[j]) {
                ++j;
            }
            result = Math.min(result, j - i - 1);
            ++i;
        }

        return result;
    }
}

