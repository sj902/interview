package com.sj902.heap;

import java.util.HashMap;
import java.util.PriorityQueue;

class PString {
    int i;
    char c;

    PString(char c, int i) {
        this.i = i;
        this.c = c;
    }
}

public class ReorganizeString {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        PriorityQueue<PString> pq = new PriorityQueue<>((a, b) -> b.i - a.i);
        PriorityQueue<PString> availability = new PriorityQueue<>((a, b) -> a.i - b.i);
        StringBuilder sb = new StringBuilder();
        int tick = 0;
        for (char c : map.keySet()) pq.add(new PString(c, map.get(c)));
        while (!pq.isEmpty() || !availability.isEmpty()) {
            while (!availability.isEmpty() && availability.peek().i <= tick) {
                PString p = availability.poll();
                pq.add(new PString(p.c, map.get(p.c)));
            }
            if (pq.isEmpty()) {
                return "";
            } else {
                PString p = pq.poll();
                map.put(p.c, map.get(p.c) - 1);
                if (p.i > 1) availability.add(new PString(p.c, tick + 2));
                sb.append(p.c);
            }
            ++tick;
        }
        return sb.toString();
    }
}
