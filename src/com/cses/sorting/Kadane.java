package com.cses.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Kadane {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long sum = Integer.parseInt(st.nextToken());
        long res = sum;
        for (int i = 1; i < n; i++) {
            int curr = Integer.parseInt(st.nextToken());
            sum = Math.max(curr, curr + sum);
            res = Math.max(res, sum);
        }
        System.out.println(res);
    }
}
