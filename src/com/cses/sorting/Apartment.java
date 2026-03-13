package com.cses.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Apartment {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        int[] b = new int[m];

        // read applicants
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        // read apartments
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(a);
        Arrays.sort(b);
        int i = 0;
        int j = 0;
        int res = 0;
        while (i < n && j < m) {
            int req = a[i];
            int apmt = b[j];
            if (apmt + k < req) {
                ++j;
            } else if (apmt - k > req) {
                ++i;
            } else {
                ++i;
                ++j;
                ++res;
            }
        }
        System.out.println(res);
    }
}




/*
*
4 3 5
60 45 80 60
30 60 75
* */