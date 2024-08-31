package com.sj902.graph;

import java.util.*;

class P {
    int nodeId;
    double prob;

    public P(int nodeId, double prob) {
        this.nodeId = nodeId;
        this.prob = prob;
    }
}

public class MaxProbability {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<Map<Integer, Double>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new HashMap<>());
        }

        for (int i = 0; i < n; i++) {
            int[] edge = edges[i];
            double prob = succProb[i];
            adj.get(edge[0]).put(edge[1], prob);
            adj.get(edge[1]).put(edge[0], prob);
        }

        double[] res = new double[n];

        PriorityQueue<P> pq = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        pq.add(new P(start_node, 1));
        res[start_node] = 1;

        while (!pq.isEmpty()) {
            P curr = pq.poll();
            if (curr.nodeId == end_node) return curr.prob;
            res[curr.nodeId] = curr.prob;
            Map<Integer, Double> neighbours = adj.get(curr.nodeId);
            for (Integer neighbour : neighbours.keySet()) {
                if (res[neighbour] < curr.prob * neighbours.get(neighbour)) {
                    pq.add(new P(neighbour, curr.prob * neighbours.get(neighbour)));
                }
            }

        }

        return res[end_node];
    }
}
