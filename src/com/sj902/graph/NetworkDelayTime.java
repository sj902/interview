package com.sj902.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            adj.add(new ArrayList<>());
        }

        int[][] price = new int[n+1][n+1];

        for (int[] edge : times) {
            adj.get(edge[0]).add(edge[1]);
            price[edge[0]][edge[1]] = edge[2];
        }
        HashMap<Integer, Integer> processed = new HashMap<>();
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        q.add(new int[]{k, 0});
        while (!q.isEmpty() && processed.size() < n) {
            int[] p = q.poll();
            if(processed.containsKey(p[0])) continue;
            processed.put(p[0], p[1]);
            for (int i: adj.get(p[0])) {
                q.add(new int[]{i, p[1]+price[p[0]][i]});
            }
        }

        int res = Integer.MIN_VALUE;
        for (int i : processed.keySet()) {
            res = Math.max(res, processed.get(i));
        }
        if(processed.size()<n)return -1;
        return res;
    }
}
