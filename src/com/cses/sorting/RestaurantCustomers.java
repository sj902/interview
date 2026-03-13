package com.cses.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RestaurantCustomers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dep = new int[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            dep[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        Arrays.sort(dep);

        int res = 0;
        int currRes = 0;
        int i = 0;
        int j = 0;

        while (i < n && j < n) {
            int a = arr[i];
            int d = dep[j];
            if (a>d){
                --currRes;
                ++j;
            } else {
                ++currRes;
                ++i;
            }
           res = Math.max(res, currRes);
        }
        System.out.println(res);
    }
}
