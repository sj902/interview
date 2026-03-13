package com.sj902.graph;

import java.util.*;

class Q{
    String s;
    int cost;

    public Q(String s, int cost) {
        this.s = s;
        this.cost = cost;
    }
}

public class OpenLock {
    public int openLock(String[] deadends, String target) {
        String start = "0000";
        Queue<Q> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>(Arrays.asList(deadends));
        q.add(new Q(start, 0));
        while (!q.isEmpty()) {
            String src = q.peek().s;
            if(src.equalsIgnoreCase(target)) return q.poll().cost;
            int costNew = q.poll().cost+1;
            String[] p = getNeighbours(src);
            for(String s: p){
                if(!visited.contains(s)){
                    q.add(new Q(s, costNew));
                }
            }
        }
        return -1;
    }

    private String[] getNeighbours(String src) {
        String[] l = new String[8];
        int j = 0;
        for (int i = 0; i < 4; ++i) {
            String s1 = src.substring(0, i) + ((src.charAt(i) - '0' + 1) % 10) + src.substring(i + 1);
            String s2 = src.substring(0, i) + ((src.charAt(i) - '0' + 9) % 10) + src.substring(i + 1);
            l[j++] = s1;
            l[j++] = s2;
        }
        return l;
    }
}
