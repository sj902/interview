package com.sj902.greedy;

import java.util.Arrays;

public class MissingRolls {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = Arrays.stream(rolls).sum();
        int m = rolls.length;
        int total = (n + m) * mean;
        int diff = total - sum;
        int[] res = new int[n];
        int floorAvg = diff / n;
        if (diff < n || diff > 6 * n) {
            return new int[]{};
        }
        Arrays.fill(res, floorAvg);
        diff = diff - (n * floorAvg);
        for (int i = 0; i < n; i++) {
            if(diff + res[i]<=6){
                res[i] = res[i]+diff;
                return res;
            }
            int newDiff = 6-res[i];
            res[i] = res[i]+newDiff;
            diff = diff - newDiff;
        }
        return res;
    }
}
