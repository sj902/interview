package com.sj902.graph;

import java.util.ArrayList;

public class NoOfConnComp {
    int[] parent;
    int[] size;

    public int countComponents(int n, int[][] prerequisites) {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[1] = 1;
        }

        int res = n;

        for (int[] edge : prerequisites) {
            int l = edge[0];
            int r = edge[1];
            int uf = union(l, r);
            res-=uf;
        }
        return res;
    }

    int find(int a) {
        if (parent[a] == a) return a;
        return find(parent[a]);
    }

    int union(int a, int b) {
        int p1 = find(a);
        int p2 = find(b);
        if (p1 == p2) return 0;
        if (size[p1] >= size[p2]) {
            size[p1] += size[p2];
            parent[p2] = p1;
        } else {
            size[p2] += size[p1];
            parent[p1] = p2;
        }
        return 1;
    }
}
