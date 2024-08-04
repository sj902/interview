package com.sj902.sliding;

public class MaxScoreCards {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int totalScore = 0;
        for (int r : cardPoints) {
            totalScore += r;
        }


        int i = 0;
        int j = 0;
        int win = n - k;
        int res = totalScore;

        int curSum = 0;
        while (j < n) {
            if (j - i + 1 < win) {
                curSum += cardPoints[j];++j;
            } else {
                res = Math.min(res, curSum);
                curSum = curSum + cardPoints[j] - cardPoints[i];
                ++j;
                ++i;
            }

        }
        res = Math.min(res, curSum);
        return totalScore - res;
    }
}
