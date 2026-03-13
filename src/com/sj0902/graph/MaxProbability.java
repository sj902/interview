package com.sj0902.graph;

import java.util.HashMap;
import java.util.PriorityQueue;

class P {
    int node;
    double prob;

    public P(int node, double prob) {
        this.node = node;
        this.prob = prob;
    }
}

public class MaxProbability {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        HashMap<Integer, HashMap<Integer, Double>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new HashMap<>());
        }
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).put(edges[i][1], succProb[i]);
            adj.get(edges[i][1]).put(edges[i][0], succProb[i]);
        }

        HashMap<Integer, Double> probs = new HashMap<>();
        probs.put(start_node, 1.0);

        PriorityQueue<P> pq = new PriorityQueue<>((a, b) -> (Double.compare(b.prob, a.prob)));
        pq.add(new P(1, 1.0));

        while (!pq.isEmpty()) {
            P curr = pq.poll();
            if (curr.node == end_node) return curr.prob;
            HashMap<Integer, Double> neighbours = adj.get(curr.node);
            for (Integer node : neighbours.keySet()) {
                if (probs.getOrDefault(node, 0.0) < (curr.prob * neighbours.get(node))) {
                    pq.add(new P(node, curr.prob * neighbours.get(node)));
                }
            }
        }
        return 0;
    }
}
