package com.cses.introductory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Permutations {
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine()).nextToken());
        StringBuilder sb = new StringBuilder();
        if (n == 2 || n == 3) {
            System.out.println("NO SOLUTION");
            return;
        }
        for (int i = 2; i <= n; i += 2) {
            sb.append(i);
            sb.append(" ");
        }
        for (int i = 1; i <= n; i += 2) {
            sb.append(i);
            sb.append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
