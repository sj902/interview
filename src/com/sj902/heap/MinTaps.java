package com.sj902.heap;


import java.util.PriorityQueue;

class Range {
    int left;
    int right;

    public Range(int left, int right) {
        this.left = left;
        this.right = right;
    }
}

public class MinTaps {
    public int minTaps(int n, int[] ranges) {
        PriorityQueue<Range> pq = new PriorityQueue<>((a, b) -> {
            if (a.left == b.left) {
                return Integer.compare(b.right, a.right);
            }
            return Integer.compare(a.left, b.left);
        });
        for (int i = 0; i <= n; i++) {
            pq.add(new Range(Math.max(0,i - ranges[i]), i + ranges[i]));
        }

        int res = 0;
        int covered = 0;

        while (covered < n) {
            if(pq.isEmpty()) return -1;
            Range leftest = pq.poll();
            if (leftest.left > covered) return -1;
            int left = leftest.left;
            int right = leftest.right;
            covered = right;
            while (!pq.isEmpty() && pq.peek().left<right){
                Range l = pq.poll();
                if(l.right>right){
                    pq.add(new Range(right, l.right));
                }
            }
            ++res;
        }
        return res;
    }
}
