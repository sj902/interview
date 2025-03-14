package com.sj0902.graph;

import java.util.*;

class PointLabyrinth {
    int x, y;

    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }

    public PointLabyrinth(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Labyrinth {
    static int m, n;
    static char[][] grid;
    static int startX, startY, endX, endY;

    static int[][] dirs;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        m = scanner.nextInt();
        n = scanner.nextInt();
        scanner.nextLine();

        grid = new char[m][n];
        dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < m; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < n; j++) {
                grid[i][j] = line.charAt(j);
                if (grid[i][j] == 'A') {
                    startX = i;
                    startY = j;
                } else if (grid[i][j] == 'B') {
                    endX = i;
                    endY = j;
                }
            }
        }

        scanner.close();

        // Call the function to solve the labyrinth (to be implemented by you)
        solveLabyrinth();
    }

    public static void solveLabyrinth() {
        boolean[][] visited = new boolean[m][n];

        PointLabyrinth[][] parent = new PointLabyrinth[m][n];

        Queue<PointLabyrinth> q = new LinkedList<>();
        q.add(new PointLabyrinth(startX, startY));
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            PointLabyrinth curr = q.poll();
            for (int[] dir : dirs) {
                int x1 = curr.x + dir[0];
                int y1 = curr.y + dir[1];
                if (x1 >= 0 && y1 >= 0 && x1 < m && y1 < n && !visited[x1][y1] && (grid[x1][y1] == '.' || grid[x1][y1] == 'A' || grid[x1][y1] == 'B')) {
                    q.add(new PointLabyrinth(x1, y1));
                    visited[x1][y1] = true;
                    parent[x1][y1] = curr;
                }
            }
        }

        if (visited[endX][endY]) {
            System.out.println("YES");
            StringBuilder s = findParent(endX, endY, parent, new StringBuilder());
            System.out.println(s.length());
            System.out.println(new StringBuilder(s).reverse());
        } else {
            System.out.println("NO");
        }

    }

    private static StringBuilder findParent(int currX, int currY, PointLabyrinth[][] parent, StringBuilder curr) {
        if (currX == startX && currY == startY) {
            return curr;
        }

        PointLabyrinth p = parent[currX][currY];
        int px = p.x;
        int py = p.y;

        if (px == currX + 1 && py == currY) {
            return findParent(px, py, parent, curr.append("U"));
        } else if (px == currX - 1 && py == currY) {
            return findParent(px, py, parent, curr.append("D"));
        } else if (px == currX && py == currY + 1) {
            return findParent(px, py, parent, curr.append("L"));
        } else {
            return findParent(px, py, parent, curr.append("R"));
        }
    }
}