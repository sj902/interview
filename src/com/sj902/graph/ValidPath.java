package com.sj902.graph;

import java.util.*;

public class ValidPath {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for(int[] edge: edges){
            ArrayList<Integer> a = map.get(edge[0]);
            a.add(edge[1]);
        }
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        while (!q.isEmpty()){
            int k = q.poll();
            visited.add(k);
            if(k == destination) return true;
            ArrayList<Integer> e = map.get(k);
            for (int i = 0; i < e.size(); i++) {
                int z = e.get(i);
                if(!visited.contains(z)){
                    q.add(z);
                }
            }
        }
        return false;
    }
}
