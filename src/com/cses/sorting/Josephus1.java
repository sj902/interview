package com.cses.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Josephus1 {
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int[] arr = new int[n];
        for (int i = 1; i <= n; i++) {
            arr[i - 1] = i;
        }
        j1(arr);
    }

    private static void j1(int[] list) {
        if (list.length == 1) {
            System.out.print(list[0] + " ");
            return;
        }

        int n = list.length;

        for (int i = 1; i < n; i += 2) {
            System.out.print(list[i] + " ");
        }

        int[] l1 = new int[(n+1)/2];

        int j = 0;

        if (n % 2 == 1) {
            l1[j++] = list[n-1];
            for (int i = 0; i < n-1; i+=2) {
                l1[j++] = list[i];
            }
        } else {
            for (int i = 0; i < n; i+=2) {
                l1[j++] = list[i];
            }
        }

        j1(l1);
    }
}
