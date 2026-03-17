package com.cses.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class StickLengths {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] sticks = new int[n];
        st = new StringTokenizer(br.readLine());
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sticks[i] = Integer.parseInt(st.nextToken());
            sum += sticks[i];
        }
        Arrays.sort(sticks);
        long avg = sum / n;
        if(n%2 == 1){
            avg = sticks[n/2];
        } else {
            avg = (sticks[n/2] + sticks[(n-1)/2])/2;
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.abs(avg - sticks[i]);
        }
        System.out.println(res);
    }
}
