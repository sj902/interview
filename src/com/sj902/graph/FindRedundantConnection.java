package com.sj902.graph;

public class FindRedundantConnection {

    int size;
    int[] parent;
    int[] rank;
    int[] res;
    boolean found;

    int find(int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent[i]);
    }

    void union(int i, int j) {
        int pI = find(i);
        int pJ = find(j);
        if (pI == pJ) {
            res = new int[]{i+1, j+1};
            found = true;
        }
        if(rank[pI]>rank[pJ]){
            rank[pI]+=rank[pJ];
            parent[pJ] = pI;
            parent[j] = pI;
        } else {
            rank[pJ]+=rank[pI];
            parent[pI] = pJ;
            parent[i] = pJ;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        size = edges.length;
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = i;
        }
        for (int i = 0; i < edges.length; i++) {
            union(edges[i][0]-1, edges[i][1]-1);
            if(found){
                return res;
            }
        }
        return new int[]{-1,-1};
    }
}
