package com.sj902.misc;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

class Obs {
    int i;
    int j;

    public Obs(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Obs obs = (Obs) o;
        return i == obs.i && j == obs.j;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j);
    }
}

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        HashSet<Obs> obs = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            obs.add(new Obs(obstacles[i][0], obstacles[i][1]));
        }
        int dir = 0; // 1,2,3,4 -> n,e,s,w
        int[] curr = new int[]{0, 0};
        int maxDist = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -1) {
                dir = (dir + 1) % 4;
            } else if (commands[i] == -2) {
                dir = (dir + 3) % 4;
            } else {
                int[] direction = directions[dir];
                for (int step = 0; step < commands[i]; step++) {
                    int nextX = curr[0] + direction[0];
                    int nextY = curr[1] + direction[1];
                    if (obs.contains(new Obs(nextX, nextY))) {
                        break;
                    }
                    curr[0] = nextX;
                    curr[1] = nextY;
                }

                maxDist = Math.max(maxDist, curr[0] * curr[0] + curr[1] * curr[1]);
            }
        }
        return maxDist;
    }
}
