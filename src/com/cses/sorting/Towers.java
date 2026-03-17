package com.cses.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Towers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        TreeMap<Integer, Integer> ts = new TreeMap<>();
        st = new StringTokenizer(br.readLine());
        int res = 0;
        for (int i = 0; i < n; i++) {
//            System.out.println(ts);
            int curr = Integer.parseInt(st.nextToken());
            Integer floor = ts.ceilingKey(curr+1);
            if (floor == null){
                ts.put(curr, ts.getOrDefault(curr, 0)+1);
                ++res;
            } else {
                ts.put(floor, ts.get(floor)-1);
                if(ts.get(floor) == 0) ts.remove(floor);
                ts.put(curr, ts.getOrDefault(curr, 0)+1);
            }
        }
        System.out.println(res);
    }
}
