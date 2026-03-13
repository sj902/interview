package com.sj902.heap;


import java.util.PriorityQueue;

class MedianFinder {
    int size;
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianFinder() {
        left = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        right = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
        size = 0;
    }

    public void addNum(int num) {
        double median = findMedian();
        if (num < median) {
            if (size % 2 == 0) {
                left.add(num);
            } else {
                right.add(left.poll());
                left.add(num);
            }
        } else {
            if (size % 2 == 0) {
                left.add(right.poll());
                right.add(num);
            } else {
                right.add(num);
            }
        }
        ++size;
    }

    public double findMedian() {
        if (size % 2 == 0) return (left.peek() + right.peek()) / 2;
        return left.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */