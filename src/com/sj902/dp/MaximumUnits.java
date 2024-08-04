package com.sj902.dp;

import java.util.Arrays;

public class MaximumUnits {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b)-> b[1]-a[1]);
        if(boxTypes[0][0]>truckSize) return truckSize*boxTypes[0][1];
        int i = 0;
        int res = 0;
        int rem = truckSize;
        while(i<boxTypes.length && rem >0){
            if(boxTypes[i][0]<=rem){
                res = res + (boxTypes[i][0]*boxTypes[i][1]);
                rem = rem - boxTypes[i][0];
            } else {
                res = res + (rem*boxTypes[i][1]);
                rem = 0;
            }
            ++i;
        }
        return res;
    }
}
