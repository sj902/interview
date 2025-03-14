package com.sj0902.graph;

import java.util.*;

public class BuildingRoads {
    static int n, m;
    static List<Integer>[] adj;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            adj[a].add(b);
            adj[b].add(a);
        }

        scanner.close();

        // Call function to determine new roads to be built (to be implemented)
        findNewRoads();
    }

    public static void findNewRoads() {
        UFRoads uf = new UFRoads(n + 1);
        for (int i = 1; i < adj.length; i++) {
            List<Integer> l = adj[i];
            for (int j = 0; j < l.size(); j++) {
                uf.union(i, l.get(j));
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            set.add(uf.find(i));
        }
        System.out.println(set.size() - 1);
        int[] arr = new int[set.size()];
        int k = 0;
        for(int i: set){
            arr[k++] = i;
        }
        for (int i = 1; i < arr.length; i++) {
            System.out.println(arr[i - 1] + " " + arr[i]);
        }
    }
}

class UFRoads {
    int[] parent;
    int[] size;

    UFRoads(int n) {
        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int find(int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent[i]);
    }

    void union(int a, int b) {
        int pA = find(a);
        int pB = find(b);
        if (pA == pB) return;
        if (size[pA] > size[pB]) {
            parent[pB] = pA;
            size[pA] += size[pB];
        } else {
            parent[pA] = pB;
            size[pB] += size[pA];
        }
    }
}

