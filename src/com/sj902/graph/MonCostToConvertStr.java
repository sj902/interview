package com.sj902.graph;

import java.util.Arrays;
import java.util.HashMap;

public class MonCostToConvertStr {

    public static void main(String[] args) {
        System.out.println(minimumCost("abcd", "acbe", new char[]{'a', 'b', 'c', 'c', 'e', 'd'},
                new char[]{'b', 'c', 'b', 'e', 'b', 'e'}, new int[]{2, 5, 5, 1, 2, 20}));
    }

    public static long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] graph = new long[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(graph[i], Long.MAX_VALUE);
        }
        int n = original.length;
        for (int i = 0; i < n; i++) {
            graph[getIndex(original[i])][getIndex(changed[i])] = cost[i];
        }

        for (int i = 0; i < 26; i++) {
            graph[i][i] = 0;
        }

        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (graph[i][k] != Long.MAX_VALUE && graph[k][j] != Long.MAX_VALUE)
                        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }


        for (int i = 0; i < 5; i++) {
            System.out.println(Arrays.toString(Arrays.copyOf(graph[i], 5)));
        }

        n = source.length();
        long res = 0;
        for (int i = 0; i < n; i++) {

            System.out.println(getIndex(source.charAt(i)));
            System.out.println(getIndex(target.charAt(i)));

            long c = graph[getIndex(source.charAt(i))][getIndex(target.charAt(i))];
            if (c == Long.MAX_VALUE) {
                return -1;
            }
            res += c;
        }
        return res;
    }

    static int getIndex(char c) {
        return (int) (c - 'a');
    }
}
