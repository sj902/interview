package com.sj902;

import java.util.Arrays;

public class ProcessExecution {

    public static void main(String[] args) throws InterruptedException {
        int[] power = new int[]{6, 7, 8, 10};
        int[] minPower = new int[]{6, 3, 4};
        int[] maxPower = new int[]{10, 7, 9};


        System.out.println(getLowerBound(9, power, 0, power.length - 1));

        long[][] res = processExecution(power, minPower, maxPower);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i][0] + "\t" + res[i][1]);
        }
    }

    public static long[][] processExecution(int[] power, int[] minPower, int[] maxPower) throws InterruptedException {
        Arrays.sort(power);
        int[] prefix = new int[power.length + 1];
        prefix[0] = 0;
        for (int i = 1; i <= power.length; i++) {
            prefix[i] = power[i - 1] + prefix[i - 1];
        }

        System.out.println();
        for (int i = 0; i < power.length; i++) {
            System.out.print(power[i] + "\t");
        }


        System.out.println();
        for (int i = 0; i <= power.length; i++) {
//            System.out.print(prefix[i] + "\t");
        }

        int n = minPower.length;
        long[][] res = new long[minPower.length][2];
        for (int i = 0; i < n; i++) {
            int leftIndex = getLowerBound(minPower[i], power, 0, power.length - 1);


            int rightIndex = getLowerBound(maxPower[i], power, 0, power.length - 1);

            System.out.println(minPower[i] + "\t" + leftIndex + "\t");
            System.out.println(maxPower[i] + "\t" + rightIndex + "\t");

            try {
                Thread.sleep(100);
            } finally {

            }
            res[i][0] = rightIndex - leftIndex + 1;
            res[i][1] = prefix[rightIndex] - prefix[leftIndex];
        }
        return res;
    }

    private static int getLowerBound(int i, int[] arr, int low, int right) {
        int l = low;
        int r = right;
        int res = 0;
        boolean found = false;
        while (l <= r) {
            int m = l + ((r - l) / 2);
            if (arr[m] > i) {
                r = m - 1;
            } else if (arr[m] == i) {
                found = true;
                res = m;
                r = m - 1;
            } else {
                if (!found) {
                    res = m;
                }
                l = m + 1;
            }
        }
        return res;
    }
}
