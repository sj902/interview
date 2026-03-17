//package com.cses.introductory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IncreasingArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long res = 0;
        st = new StringTokenizer(br.readLine());
        int min = 1;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                min = Integer.parseInt(st.nextToken());
            } else {
                int curr = Integer.parseInt(st.nextToken());
                if (curr < min) {
                    res += (min - curr);
                }
                min = Math.max(curr, min);
            }
        }
        System.out.println(res);
    }
}
