package com.sj0902.sliding;

public class NumberOfAlternatingGroups {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int l = 0;
        int r = 1;
        int n = colors.length;
        int res = 0;
        while(r<n+k-1){
            if(colors[(r-1)%n]==colors[r%n]){
                l = r;
            } else {
                if(r-l+1 > k){
                    ++l;
                }
                if(r-l+1 == k){
                    ++res;
                    ++l;
                }
            }
            ++r;
        }
        return res;
    }
}
