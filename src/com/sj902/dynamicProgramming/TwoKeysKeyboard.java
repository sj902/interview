package com.sj902.dynamicProgramming;

public class TwoKeysKeyboard {
    public int minSteps(int n) {
        if(n == 1) return 0;
        return 1+aux(n, 1, 1);
    }

    private int aux(int n, int screen, int cb) {
        if (screen == n) return 0;
        if (screen > n) return n + 1;
        if (screen == cb) {
            return 1 + aux(n, screen + cb, cb);
        } else {
            int a = 1 + aux(n, screen, screen);
            int b = 1 + aux(n, screen + cb, cb);
            return 1 + Math.min(a, b);
        }
    }
}
