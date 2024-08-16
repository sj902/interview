package com.sj902.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class FindCheapestPrice {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] price = new int[n][n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        HashMap<Integer, Integer> priceMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            int i = flight[0];
            int j = flight[1];
            int p = flight[2];
            adj.get(i).add(j);
            price[i][j] = p;
        }
        int res = Integer.MAX_VALUE;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, 0});
        while (!q.isEmpty() && k >= -1) {
            int l = q.size();
            for (int i = 0; i < l; i++) {
                int[] p = q.poll();
                int pr = p[1];
                int node = p[0];
                System.out.println(node+":"+pr+":"+k);
                if (node == dst) {
                    res = Math.min(res, pr);
                }
                for (Integer no : adj.get(node)) {
                    if(priceMap.containsKey(no) && priceMap.get(no)>pr + price[node][no]) {
                        q.add(new int[]{no, pr + price[node][no]});
                        priceMap.put(no, pr + price[node][no]);
                    }
                }
            }
            --k;
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
