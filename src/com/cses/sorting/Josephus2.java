//package com.cses.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Josephus2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 1; i <= n; i++) {
            arr[i - 1] = i;
        }
        if (k == 0) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            return;
        }
        j1(arr, k);
    }

    private static void j1(int[] list, int k) {
        System.out.println("arr:"+Arrays.toString(list));
        System.out.println(Arrays.toString(list));
        if (list.length == 1) {
            for (int i = 0; i < list.length; i++) {
                System.out.print(list[i] + " ");
            }
            return;
        }
        if (list.length < k) {
            for (int i = 0; i < list.length; i++) {
                System.out.print(list[i] + " ");
            }
            return;
        }

        int n = list.length;

        int last = (n / k) * k;
        int[] l1 = new int[(n + 1) - k];
        int j = 0;

        for (int i = 1; i <= last; i ++) {
            if (i % k == 0) {
                System.out.print(list[i - 1] + " ");
            }
        }

        for (int i = last; i < n; i++) {
            l1[j++] = list[i];
        }


        for (int i = 1; i <= last; i ++) {
            if (i % k != 0) {
                l1[j++] = list[i-1];
            }
        }

        j1(l1, k);
    }
}


/*

 *
 * */