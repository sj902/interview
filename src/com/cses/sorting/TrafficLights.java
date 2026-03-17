package com.cses.sorting;

import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.TreeMap;

public class TrafficLights {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        TreeSet<Integer> ts = new TreeSet<>();
        TreeMap<Integer, Integer> gaps = new TreeMap<>();
        gaps.put(x, 1);
        ts.add(0);
        ts.add(x);
        for (int i = 0; i < n; i++) {
            int curr = Integer.parseInt(st.nextToken());
            int lower = ts.floor(curr);
            int higher = ts.ceiling(curr);

            int prevGap = higher - lower;
            int currGapLow = curr - lower;
            int currGapHigh = higher - curr;
            int pg = gaps.get(prevGap);

            gaps.put(prevGap, pg - 1);

            if (pg - 1 == 0) gaps.remove(prevGap);
            gaps.merge(currGapLow, 1, Integer::sum);
            gaps.merge(currGapHigh, 1, Integer::sum);

            ts.add(curr);
            if (i > 0) sb.append(' ');
            sb.append(gaps.lastKey());
        }
        pw.println(sb);
        pw.flush();
    }
}
