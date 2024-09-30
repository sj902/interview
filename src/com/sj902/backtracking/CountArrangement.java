package com.sj902.backtracking;

public class CountArrangement {

    int count = 0;

    public int countArrangement(int n) {
        boolean[] visited = new boolean[n];
        aux(n, 1, visited);
        return count;
    }

    private void aux(int n, int i, boolean[] visited) {
        if (i > n) {
            ++count;
            return;
        }
        for (int j = 1; j <= n; j++) {
            if (!visited[j] && (i % j == 0 || j % i == 0)) {
                visited[j] = true;
                aux(n, j+1, visited);
                visited[j] = false;
            }
        }
    }
}
