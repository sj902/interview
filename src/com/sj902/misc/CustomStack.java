package com.sj902.misc;

class CustomStack {

    int max;
    int[] dq;
    int currSize;

    public CustomStack(int maxSize) {
        max = maxSize;
        dq = new int[maxSize];
        currSize = 0;
    }

    public void push(int x) {
        if (currSize == max) {
            return;
        }
        dq[currSize++] = x;
    }

    public int pop() {
        if (currSize > 0) {
            return dq[--currSize];
        }
        return -1;
    }

    public void increment(int k, int val) {
        int i = 0;
        while (i < k && i < currSize) {
            dq[i] = dq[i]+val;
            ++i;
        }
    }
}
