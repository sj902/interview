package com.cses.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Playlist {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int arr[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int i = 0;
        int j = 0;
        int res = 1;
        HashSet<Integer> set = new HashSet<>();
        while (i<n && j<n){
            int curr = arr[j];
            while(set.contains(curr)){
                int q = arr[i];
                set.remove(q);
                ++i;
            }
            set.add(curr);
            res = Math.max(res, j-i+1);
            ++j;
        }
        System.out.println(res);
    }
}
