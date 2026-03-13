package com.sj902.graph;

import java.util.*;

public class ModifiedGraphEdges {
    List<Map<Integer, Integer>> adj;
    int noOfEdges;
    int maxVal;

    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        adj = new ArrayList<>();
        noOfEdges = n;
        maxVal = target + 1;
        for (int i = 0; i < n; i++) {
            adj.add(new HashMap<>());
        }

        for (int[] edge : edges) {
            Map<Integer, Integer> map = adj.get(edge[0]);
            map.put(edge[1], edge[2]);
            Map<Integer, Integer> map2 = adj.get(edge[1]);
            map2.put(edge[0], edge[2]);
        }

        int minPath = findMin(source, destination);
        if (minPath < target) return new int[][]{};

        boolean found = false;
        int minDist = target + 1;
        int idx = -1;

        for (int i = 0; i < edges.length; ++i) {
            int[] edge = edges[i];
            if (edge[2] > 0) continue;
            edge[2] = 1;
            adj.get(edge[0]).put(edge[1], 1);
            adj.get(edge[1]).put(edge[0], 1);
            int currMin = findMin(source, destination);
            if (currMin <= target) {
                found = true;
                minDist = currMin;
                idx = i;
                break;
            }
        }
        if (!found) return new int[][]{};

        int diff = target - minDist;
        edges[idx][2] = diff + 1;

        for (int i = 0; i < edges.length; ++i) {
            int[] edge = edges[i];
            if (edge[2] < 0) {
                edge[2] = target;
            }
        }
        return edges;
    }

    private int findMin(int source, int destination) {
        int n = noOfEdges;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = maxVal;
        }
        int finalCost = -1;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (Integer.compare(a[1], b[1])));
        pq.add(new int[]{source, 0, -1});
        res[source] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currNodeId = curr[0];
            int currWt = curr[1];
            res[currNodeId] = currWt;
            if (currNodeId == destination) {
                finalCost = currWt;
                break;
            }
            for (Integer nId : adj.get(currNodeId).keySet()) {
                if (res[nId] == maxVal && adj.get(currNodeId).get(nId) > 0) {
                    int wt = adj.get(currNodeId).get(nId);
                    pq.add(new int[]{nId, currWt + wt, currNodeId});
                }
            }
        }
        return res[destination];
    }
}
