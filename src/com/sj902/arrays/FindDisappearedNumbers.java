package com.sj902.arrays;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] a) {
        List<Integer> res = new ArrayList<>();
        int n = a.length;

        for(int i = 0; i< n; ++i){
            while(a[i]!=i+1 || a[i]!=a[a[i]-1]){
                swap(a, i, a[i]-1);
            }
        }


        for (int i = 0; i < n; i++) {
            if(a[i]!=i+1){
                res.add(i+1);
            }
        }
return res;

    }

    private void swap(int[] a, int i, int i1) {
        int t = a[i];
        a[i] = a[i1];
        a[i1] = t;
    }
}
