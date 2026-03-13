package com.sj0902.graph;

import java.util.*;

public class TwoTeams {
    static int n, m;
    static List<Integer>[] adj;
    static int[] team;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        adj = new ArrayList[n + 1];
        team = new int[n + 1];

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
        assignTeams();
    }

    public static void assignTeams() {
        for (int i = 1; i <= n; i++) {
            if (team[i] == 0) {
                boolean k = dfs(i, 0);
                if (!k) {
                    System.out.println("IMPOSSIBLE");
                    return;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.println(team[i] + " ");
        }
    }

    private static boolean dfs(int i, int prevColor) {
        if (team[i] != 0) {
            return team[i] != prevColor;
        }
        if (prevColor == 1) {
            team[i] = 2;
        } else {
            team[i] = 1;
        }
        for (int node : adj[i]) {
            boolean k = dfs(node, team[i]);
            if (!k) {
                return false;
            }
        }
        return true;
    }
}

