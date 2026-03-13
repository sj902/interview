package com.sj902.heap;

import java.util.HashMap;
import java.util.PriorityQueue;

class Pair1 {
    char c;
    int i;

    public Pair1(char c, int i) {
        this.c = c;
        this.i = i;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "c=" + c +
                ", i=" + i +
                '}';
    }
}

public class TaskScheduler {
    public static void main(String[] args) {
        leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2);
    }

   static public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Pair1> pq = new PriorityQueue<>((a, b) -> b.i - a.i);
        PriorityQueue<Pair1> available = new PriorityQueue<>((a, b) -> a.i - b.i);
        int tick = 0;
        for (char c : map.keySet()) {
            pq.add(new Pair1(c, map.get(c)));
        }
        while (!pq.isEmpty() || !available.isEmpty()) {
            while (!available.isEmpty() && available.peek().i <= tick) {
                char c = available.poll().c;
                pq.add(new Pair1(c, map.get(c)));
            }
            Pair1 p = pq.poll();
            if (p.i > 1) {
                map.put(p.c, map.get(p.c) - 1);
                available.add(new Pair1(p.c, tick + n+1));
            }
            ++tick;
        }
        return tick;
    }
}
