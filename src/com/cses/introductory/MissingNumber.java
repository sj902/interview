//package com.cses.introductory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MissingNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int xor = 0;
        for (int i = 1; i <= n; i++) {
            xor = xor ^ i;
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n-1; i++) {
            xor = xor ^ Integer.parseInt(st.nextToken());
        }
        System.out.println(xor);
    }
}
