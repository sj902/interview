package com.sj902.misc;

import java.util.Arrays;

public class ChalkReplacer {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        int n = chalk.length;
        for (int i = 0; i < n; i++) {
            sum += chalk[i];
        }
        long h = k % sum;

        for (int i = 0; i < n; i++) {
            h = h-chalk[i];
            if(h<0) return i;
        }
        return n;
    }
}
