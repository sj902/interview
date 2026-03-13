package com.sj902.graph;

import java.util.*;

public class ReconstructItinerary {
    List<String> res;
    Map<String, PriorityQueue<String>> adj;

    public List<String> findItinerary(List<List<String>> tickets) {
        res = new ArrayList<>();
        adj = new HashMap<>();
        for (List<String> ticket : tickets) {
            PriorityQueue<String> nodes = adj.getOrDefault(ticket.get(0), new PriorityQueue<>());
            nodes.add(ticket.get(1));
            adj.put(ticket.get(0),nodes);
        }
        dfs("JFK");
        Collections.reverse(res);
        return res;
    }

    void dfs(String src){
        PriorityQueue<String> nodes = adj.getOrDefault(src, new PriorityQueue<>());
        if(nodes.isEmpty()){
            res.add(src);
        } else {
            while (!nodes.isEmpty()){
                dfs(nodes.poll());
            }
        }
        res.add(src);
    }
}
