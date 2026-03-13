package com.sj902.misc;

import java.util.HashMap;
import java.util.Stack;

class FreqStack {
    HashMap<Integer, Integer> freqMap;
    HashMap<Integer, Stack<Integer>> map;
    int maxFreq;

    public FreqStack() {
        freqMap = new HashMap<>();
        map = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {
        int freq = freqMap.getOrDefault(val, 0) + 1;
        freqMap.put(val, freq);

        Stack<Integer> stack = map.getOrDefault(freq, new Stack<>());
        stack.push(val);
        map.put(freq, stack);
        maxFreq = Math.max(maxFreq, freq);
    }

    public int pop() {
        Stack<Integer> maxFreqStack = map.get(maxFreq);
        int res = maxFreqStack.pop();
        freqMap.put(res, maxFreq - 1);
        if (maxFreqStack.isEmpty()) --maxFreq;
        return res;
    }
}
