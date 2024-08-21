package com.sj902.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->{
            if(Math.abs(a - x) == Math.abs(b - x)){
                return a-b;
            } return Math.abs(a - x) - Math.abs(b - x);
        });
        for(int n: arr) pq.add(n);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(pq.poll());
        }
        return res;
    }
}
