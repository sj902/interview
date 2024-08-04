package com.sj902.intervals;

import java.util.Arrays;

public class IntervalIntersection {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int m = firstList.length;
        int n = secondList.length;
        int i = 0;
        int j = 0;
        int len = 0;
        int[][] res = new int[Math.min(m, n)][2];
        while (i < m && j < n){
            int s1 = firstList[i][0];
            int s2 = secondList[j][0];
            int e1 = firstList[i][1];
            int e2 = secondList[i][2];
            if((s1<=e2 && s2<=e1)){
                res[len][0] = Math.max(s1,s2);
                res[len][1] = Math.min(e1,e2);
                ++len;
            }
            if(firstList[i][i]<secondList[j][1]){
                ++i;
            } else {
                ++j;
            }
        }
        return Arrays.copyOf(res, len);
    }
}
