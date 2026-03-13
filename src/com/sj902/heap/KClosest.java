package com.sj902.heap;

import java.util.PriorityQueue;

public class KClosest {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (int)(getDist(a) - getDist(b)));
        for (int i = 0; i < points.length; i++) {
            int[] p = points[i];
            pq.add(new int[]{p[0], p[1]});
        }
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }

    private double getDist(int[] a) {
        return Math.sqrt((a[0]*a[0]) + (a[1]*a[1]));
    }
}
