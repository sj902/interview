package com.sj902.dp;

public class KnightDialer {
    public static void main(String[] args) {
        System.out.println(knightDialer(3131));
    }

    static Integer res[][];

    static public int knightDialer(int n) {
        res = new Integer[10][n + 1];
        int r = 0;
        for (int i = 0; i < 10; i++) {
            r += aux(i, n - 1) % 1000000007;
        }
        return r;
    }

    static private int aux(int pos, int n) {
        if (n == 0) return 1;

        if (res[pos][n] != null) return res[pos][n];
        switch (pos) {
            case 1:
                return res[pos][n] = (aux(6, n - 1) % 1000000007 + aux(8, n - 1) % 1000000007) % 1000000007;
            case 2:
                return res[pos][n] = (aux(7, n - 1) % 1000000007 + aux(9, n - 1) % 1000000007) % 1000000007;
            case 3:
                return res[pos][n] = (aux(4, n - 1) % 1000000007 + aux(8, n - 1) % 1000000007) % 1000000007;
            case 4:
                return res[pos][n] = (aux(0, n - 1) % 1000000007 + aux(3, n - 1) % 1000000007 + aux(9, n - 1) % 1000000007) % 1000000007;
            case 5:
                return res[pos][n] = (0) % 1000000007;
            case 6:
                return res[pos][n] = (aux(0, n - 1) % 1000000007 + aux(1, n - 1) % 1000000007 + aux(7, n - 1) % 1000000007) % 1000000007;
            case 7:
                return res[pos][n] = (aux(2, n - 1) % 1000000007 + aux(6, n - 1) % 1000000007) % 1000000007;
            case 8:
                return res[pos][n] = (aux(1, n - 1) % 1000000007 + aux(3, n - 1) % 1000000007) % 1000000007;
            case 9:
                return res[pos][n] = (aux(2, n - 1) % 1000000007 + aux(4, n - 1) % 1000000007) % 1000000007;
            case 0:
                return res[pos][n] = (aux(4, n - 1) % 1000000007 + aux(6, n - 1) % 1000000007) % 1000000007;
        }
        return res[pos][n] = (0) % 1000000007;
    }
}
