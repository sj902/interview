//package com.sj0902.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class BuildingRoadsDFS {
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

    static boolean[] visited;
    static ArrayList<Integer> list;

    public static void findNewRoads() {
        visited = new boolean[n + 1];
        list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                list.add(i);
                dfs(i);
            }
        }
        System.out.println(list.size() - 1);
        for (int i = 1; i < list.size(); i++) {
            System.out.println(list.get(i - 1) + " " + list.get(i));
        }
    }

    private static void dfs(int i) {
        visited[i] = true;
        List<Integer> a = adj[i];
        if (a == null) return;
        for (int j = 0; j < adj[i].size(); j++) {
            if (!visited[adj[i].get(j)]) {
                dfs(adj[i].get(j));
            }
        }
    }
}
