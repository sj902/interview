package com.sj902.graph;

import java.util.ArrayList;

public class ValidTree {
    int[] parent;
    int[] size;

    public boolean validTree(int n, int[][] prerequisites) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }


        for (int[] edge : prerequisites) {
            int l = edge[0];
            int r = edge[1];
            boolean uf = union(l, r);
            if (!uf) {
                return false;
            }
        }
        int c = 0;
        for (int i = 0; i < n; ++i) {
            System.out.println(parent[i] + "-" + i);
            if (parent[i] == i) {
                ++c;
            }
        }
        return c <= 1;
    }

    int find(int a) {
        if (parent[a] == a) return a;
        return find(parent[a]);
    }

    boolean union(int a, int b) {
        int p1 = find(a);
        int p2 = find(b);
        if (p1 == p2) return false;
        if (size[p1] >= size[p2]) {
            size[p1] += size[p2];
            parent[p2] = p1;
        } else {
            size[p2] += size[p1];
            parent[p1] = p2;
        }
        return true;
    }
}
