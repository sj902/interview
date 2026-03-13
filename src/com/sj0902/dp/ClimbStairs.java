package com.sj0902.dp;

public class ClimbStairs {
    public int climbStairs(int n) {
        return aux(n);
    }

    private int aux(int n) {
        if (n == 0) return 1;
        int one = 0;
        int two = 0;
        if (n - 1 >= 0) one = aux(n - 1);
        if (n - 2 >= 0) two = aux(n - 2);
        return one + two;
    }
}
