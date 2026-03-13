package com.sj902.binarySearch;

public class PeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0;
        int h = arr.length-1;
        while (l<=h){
            int m = l+((h-l)/2);
            boolean gl = m == 0 || arr[m]>arr[m-1];
            boolean gr = m == arr.length-1 || arr[m]>arr[m+1];
            if(gl && gr) return m;
            else if (gl)  {
                l = m+1;
            } else h = m-1;
        }
        return l;
    }
}
