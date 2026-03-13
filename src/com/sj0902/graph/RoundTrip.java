//package com.sj0902.graph;

import java.util.*;

public class RoundTrip {
    static int n, m;
    static List<Integer>[] adj;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        adj = new ArrayList[n + 1];
        parent = new int[n + 1];

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

        findCycle();
    }

    public static void findCycle() {
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            ArrayList<Integer> res = new ArrayList<>();
            dfs(i, i, res);
            if (res.size() >= 4) {
                System.out.println(res.size());
                System.out.println(Arrays.toString(res.toArray()));
                return;
            }
        }
        System.out.println("IMPOSSIBLE");
    }

    private static void dfs(int i, int target, ArrayList<Integer> res) {
        visited[i] = true;
        res.add(i);
        if (res.size() >= 4 && i == target) {
            return;
        }
        for (int n : adj[i]) {
            if (n == target && res.size() >= 3) {
                res.add(n);
                return;
            }
            if (!visited[n]) {
                dfs(n, target, res);
            }
        }
    }

}
