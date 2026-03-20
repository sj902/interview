package com.cses.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DistinctValuesSubsequences {
    public static void main(String[] args) throws IOException {
        int MOD = 1000000007;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        TreeMap<Integer, Integer> map = new TreeMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            int k = map.getOrDefault(a, 0);
            map.put(a, k + 1);
        }
        long res = 1;

        List<Integer> s = new ArrayList<>(map.keySet());

        for (Integer i : s) {
            res = res*(1+map.get(i));
            res = res % MOD;
        }

        System.out.println(res-1);
    }
}
