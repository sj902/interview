package com.sj902.graph;

import java.util.ArrayList;

public class FindCircleNum {

    boolean[] visted;

    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        visted = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected.length; j++) {
                if(i != j){
                    adj.get(i).add(j);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if(!visted[i]){
                ++res;
                dfs(visted, adj, i);
            }
        }
        return res;
    }

    private void dfs(boolean[] visted, ArrayList<ArrayList<Integer>> adj, int i) {
        visted[i] = true;
        for (int node: adj.get(i)) {
            if(!visted[node]){
                dfs(visted, adj, node);
            }
        }
    }
}
