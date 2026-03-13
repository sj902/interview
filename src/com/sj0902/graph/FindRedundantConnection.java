package com.sj0902.graph;


public class FindRedundantConnection {
    int[] parent;
    int[] size;
    int[] res;

    int find(int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent[i]);
    }

    void union(int a, int b) {
        int pA = find(a);
        int pB = find(b);
        if (pA == pB) {
            res = new int[]{a, b};
            return;
        }
        if (size[pA] > size[pB]) {
            parent[pB] = parent[pA];
            size[pA] += size[pB];
        } else {
            parent[pA] = parent[pB];
            size[pB] += size[pA];
        }
    }


    public int[] findRedundantConnection(int[][] edges) {
        res = new int[]{-1, -1};
        parent = new int[edges.length];

        for (int i = 0; i < edges.length; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        for (int[] edge : edges) {
            union(edge[0], edge[1]);
            if (res[0] != -1) return res;
        }
        return res;
    }
}
