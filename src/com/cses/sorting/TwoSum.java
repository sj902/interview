//package com.cses.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class TwoSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer> set = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int curr = Integer.parseInt(st.nextToken());
            int target = x - curr;
            if (set.containsKey(target)) {
                System.out.println((i+1) + " " + (set.get(target)+1));
                return;
            }
            set.put(curr, i);
        }
        System.out.println("IMPOSSIBLE");
    }
}
