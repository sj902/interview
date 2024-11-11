package com.sj902.bitwise;

public class MinEnd {
    public long minEnd(int n, int x) {
        --n;
        long bit;
        long longX = x;
        long longN = n;
        int[] binX = new int[64];
        int[] binN = new int[64];

        for (int i = 0; i < 64; i++) {
            bit = (longX >> i) & 1;
            binX[i] = (int) bit;

            bit = (longN >> i) & 1;
            binN[i] = (int) bit;
        }

        int posX = 0, posN = 0;

        while (posX < 64) {
            while (binX[posX] != 0 && posX < 64) {
                ++posX;
            }
            binX[posX] = binN[posN];
            ++posX;
            ++posN;
        }

        long result = 0;

        for (int i = 0; i < 64; ++i) {
            if (binX[i] == 1) {
                result += Math.pow(2, i);
            }
        }

        return result;
    }
}
