package com.cses.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NestedRangesCheck {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] times = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            times[i] = new int[]{a, b, i};
        }

        Arrays.sort(times, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(b[1], a[1]);
            return Integer.compare(a[0], b[0]);
        });

        int[] contains = new int[n];
        int[] isContained = new int[n];


        int currMax = times[0][1];
        for (int i = 1; i < n; i++) {
            if (times[i][1] <= currMax) {
                isContained[times[i][2]] = 1;
            }
            currMax = Math.max(currMax, times[i][1]);
        }

        int minEnd = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (times[i][1] >= minEnd) {
                contains[times[i][2]] = 1;
            }
            minEnd = Math.min(minEnd, times[i][1]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
           sb.append(contains[i]);
           sb.append(" ");
        }
        System.out.println(sb);
        sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(isContained[i]);
            sb.append(" ");
        }
        System.out.println(sb);
    }
}
