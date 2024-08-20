package com.sj902.backtracking;

public class MyPow {
    public double myPow(double x, int n) {
        double res = 1;
        while (n >= 1) {
            if (n % 2 == 1) {
                res = res * x;
                --n;
            } else {
                x = x * x;
                n /= 2;
            }
        }
        return res;
    }
}
