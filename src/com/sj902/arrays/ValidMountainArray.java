package com.sj902.arrays;

public class ValidMountainArray {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if (n < 3) return false;
        boolean isDec = false;
        for (int i = 1; i < n; ++i) {
            if (arr[i] == arr[i - 1]) return false;
            if(isDec){
                if (arr[i] > arr[i - 1]) return false;
            } else {
                if (arr[i] < arr[i - 1]) {
                    isDec = true;
                }
            }
        }
        return true;
    }
}
