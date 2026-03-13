package com.sj902.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindMinHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[n];
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
            indegree[edge[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 1) {
                q.add(i);
            }
        }

        int n1 = n;
        while (n1 > 2) {
            int l = q.size();
            n1 = n1 - l;
            for (int i = 0; i < l; i++) {
                int p = q.poll();
                ArrayList<Integer> adjlist = adj.get(p);
                for (int a : adjlist) {
                    indegree[a]--;
                    if (indegree[a] == 1) {
                        q.add(a);
                    }
                }
            }
        }
        ArrayList<Integer> res = new ArrayList<>(q);
        return res;
    }
}
