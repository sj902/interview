package com.sj902.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class FindItinerary {
    List<String> res;
    HashMap<String, PriorityQueue<String>> adj;
    public List<String> findItinerary(List<List<String>> tickets) {
        res = new ArrayList<>();
        adj = new HashMap<>();
        for(List<String> ticket: tickets){
            PriorityQueue<String> pq = adj.getOrDefault(ticket.get(0), new PriorityQueue<>());
            pq.add(ticket.get(1));
            adj.put(ticket.get(0), pq);
        }
        dfs("JFK");
        return res;
    }

    private void dfs(String src) {
        while (adj.containsKey(src) && !adj.get(src).isEmpty())
            dfs(adj.get(src).poll());
        res.add(0, src);
    }
}
