package com.sj902.sliding;

public class CardPoints {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int begin = 0;
        int end = n-1;
        return maxScoreAux( cardPoints,  k, begin, end, 0);
    }

    private int maxScoreAux(int[] arr, int k, int begin, int end, int curr) {
        if(k == 0)return curr;
        int last = maxScoreAux(arr, k-1, begin, end-1, curr+arr[end]);
        int first = maxScoreAux(arr, k-1, begin+1, end, curr+arr[begin]);
        return Math.max(last, first);
    }
}
