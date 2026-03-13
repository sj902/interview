package com.sj902.heap;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.PriorityQueue;

public class KthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
                           HashSet<Pair<Integer, Integer>> visited= new  HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> matrix[a[0]][a[1]] - matrix[b[0]][b[1]]);
        pq.add(new int[]{0, 0});
        visited.add(new Pair<>(0,0));
        while (k > 1) {
            int[] p = pq.poll();
            int r = p[0];
            int c = p[1];
            if (r + 1 < n && !visited.contains(new Pair<>(r+1,c))) {
                pq.add(new int[]{r + 1, c});
                visited.add(new Pair<>(r+1,c));
            }
            if (c + 1 < n && !visited.contains(new Pair<>(r,c+1))) {
                pq.add(new int[]{r, c + 1});
                visited.add(new Pair<>(r,c+1));
            }
            --k;
        }
        int[] a = pq.poll();
        return matrix[a[0]][a[1]];
    }
}
