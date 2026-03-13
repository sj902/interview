package com.sj902.heap;

import java.util.HashMap;
import java.util.PriorityQueue;

class Sol {
    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(4);
        freqStack.push(0);
        freqStack.push(9);
        freqStack.push(3);
        freqStack.push(4);
        freqStack.push(2);
        System.out.println(freqStack.pop());
        freqStack.push(6);
        System.out.println(freqStack.pop());
        freqStack.push(1);
        System.out.println(freqStack.pop());
        freqStack.push(1);
        System.out.println(freqStack.pop());
        freqStack.push(4);
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
    }
}

class P {
    int i;
    int freq;
    int tick;

    public P(int i, int freq, int tick) {
        this.i = i;
        this.freq = freq;
        this.tick = tick;
    }
}

class FreqStack {
    HashMap<Integer, Integer> map;
    PriorityQueue<P> pq;
    int tick;

    public FreqStack() {
        map = new HashMap<>();
        pq = new PriorityQueue<>((a, b) -> {
            if (a.freq == b.freq) return b.tick - a.tick;
            return b.freq - a.freq;
        });
        tick = 0;
    }

    public void push(int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
        pq.add(new P(val, map.get(val), tick));
        ++tick;
    }

    public int pop() {
        P p = pq.poll();
        map.put(p.i, map.get(p.i) - 1);
        return p.i;
    }
}
