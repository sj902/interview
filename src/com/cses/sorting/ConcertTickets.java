package com.cses.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class ConcertTickets {
    static int[] parent;

    static int find(int i) {
        if (i < 0) return -1;
        if (parent[i] == i) return i;
        return parent[i] = find(parent[i]);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int[] tickets = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tickets[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(tickets);

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int price = Integer.parseInt(st.nextToken());

            int bins = Arrays.binarySearch(tickets, price);
            if (bins < 0) bins = -bins - 2;
            else  while (bins + 1 < n && tickets[bins + 1] == tickets[bins]) bins++;

            int res = find(bins);
            if (res >= 0) {
                sb.append(tickets[res]);
                parent[res] = find(res - 1);
            } else {
                sb.append(-1);
            }


            sb.append("\n");
        }
        System.out.println(sb);
    }
}
