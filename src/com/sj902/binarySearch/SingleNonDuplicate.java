package com.sj902.binarySearch;

public class SingleNonDuplicate {
    public int singleNonDuplicate(int[] a) {
        int l = 0;
        int h = a.length-1;
        while (l<=h){
            int mid = l+((h-l)/2);
            if(mid %2 == 1) --mid;
            if(a[mid] == a[mid+1]){
                h = mid;
            } else {
                l = mid+2;
            }
        }
        return a[l];
    }
}
