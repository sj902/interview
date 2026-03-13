package com.sj902.binarySearch;

public class ShipWithinDays {
    public static void main(String[] args) {
        System.out.print(shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
    }

    public static int shipWithinDays(int[] weights, int days) {
        long sum = 0;
        for (int w :
                weights) {
            sum += w;
        }
        long l = 1;
        long h = sum;
        long res = Long.MAX_VALUE;
        while (l < h) {
            long m = l + ((h - l) / 2);
            if (canShip(weights, days, m)) {
                res = m;
                h = m - 1;
            } else l = m + 1;
        }
        return (int) res;
    }

    private static boolean canShip(int[] weights, int days, long m) {
        int j = 0;
        int res = 1;
        int curr = 0;
        while (j<weights.length){
            if(curr + weights[j]>m){
                curr = 0;
                ++res;
            }
            curr = curr+weights[j];
            ++j;
        }
        return res <= days;
    }
}
