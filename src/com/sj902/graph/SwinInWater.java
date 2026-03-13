package com.sj902.graph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SwinInWater {
    class P {
        int height, row, col;

        public P(int height, int row, int col) {
            this.height = height;
            this.row = row;
            this.col = col;
        }
    }

    public int swimInWater(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        PriorityQueue<P> pq = new PriorityQueue<>(new Comparator<P>() {
            @Override
            public int compare(P o1, P o2) {
                return 0;
            }
        });
        pq.add(new P(heights[0][0], 0, 0));

        Set<String> visited = new HashSet<>();

        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while (!pq.isEmpty()) {
            P curr = pq.poll();
            int h = curr.height;
            int r = curr.row;
            int c = curr.col;

            if (visited.contains(r + "-" + c)) {
                continue;
            }
            visited.add(r + "-" + c);

            if (r == m - 1 && c == n - 1) {
                return h;
            }

            for (int[] dir : dirs) {
                int x = r + dir[0];
                int y = c + dir[1];
                if (x < 0 || y < 0 || x >= m || y >= n) {
                    continue;
                }
                pq.add(new P(Math.max(h, heights[x][y]), x, y));
            }
        }
        return 0;
    }
}
