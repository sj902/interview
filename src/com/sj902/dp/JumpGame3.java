package com.sj902.dp;

import java.util.Arrays;

public class JumpGame3 {
    boolean[] visited;
    int[] res;

    public boolean canReach(int[] arr, int start) {
        visited = new boolean[arr.length];
        res = new int[arr.length];
        Arrays.fill(res, -1);
        return canReachAux(arr, start);
    }

    private boolean canReachAux(int[] arr, int start) {
        if (start < 0 || start >= arr.length ||visited[start]) return false;
        visited[start] = true;
        if (arr[start] == 0) return true;
        System.out.println(start);
        return canReachAux(arr, start + arr[start]) || canReachAux(arr, start - arr[start]);
    }
}
