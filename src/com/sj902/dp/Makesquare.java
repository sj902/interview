package com.sj902.dp;

public class Makesquare {
    int[] arr;
    int[] sides;
    int target;

    public boolean makesquare(int[] matchsticks) {
        arr = matchsticks;
        sides = new int[4];
        int sum = 0;
        for (int n : arr) sum += n;
        if (sum % 4 != 0) return false;
        target = sum / 4;
        return aux(0);
    }

    boolean aux(int idx) {
        if (idx == arr.length) return true;
        for (int i = 0; i < 4; i++) {
            if (sides[i] + arr[idx] <= target) {
                sides[i] += arr[idx];
                if (aux(idx + 1)) return true;
                sides[i] -= arr[idx];
                if (sides[i] == 0) break;
            }
        }
        return false;
    }
}
