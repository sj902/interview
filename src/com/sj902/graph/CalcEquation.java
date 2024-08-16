package com.sj902.graph;

import java.util.HashMap;
import java.util.List;

public class CalcEquation {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, Integer> map = new HashMap<>();
        int counter = 0;
        for (List<String> l : equations) {
            for (String s : l) {
                if (!map.containsKey(s)) {
                    map.put(s, counter++);
                }
            }
        }

        int n = map.size();
        double[][] grid = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    grid[i][j] = 1;
                } else {
                    grid[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < equations.size(); i++) {
            int s = map.get(equations.get(i).get(0));
            int d = map.get(equations.get(i).get(1));
            double p = values[i];
            grid[s][d] = p;
            grid[d][s] = 1.0 / p;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] != -1) continue;
                    double a = grid[i][k];
                    double b = grid[k][j];
                    if (a != -1 && b != -1) {
                        grid[i][j] = a * b;
                        grid[j][i] = 1 / (a * b);
                    }
                }
            }
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            int s = map.getOrDefault(queries.get(i).get(0), -1);
            int d = map.getOrDefault(queries.get(i).get(1), -1);
            if (s == -1 || d == -1) {
                res[i] = -1;
            } else {
                res[i] = grid[s][d];
            }
        }
        return res;
    }
}
