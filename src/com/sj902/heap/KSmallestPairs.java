package com.sj902.heap;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

class PNums {
    int sum;
    int num1idx;
    int num2idx;

    public PNums( int num1idx, int num2idx, int sum) {
        this.sum = sum;
        this.num1idx = num1idx;
        this.num2idx = num2idx;
    }
}

public class KSmallestPairs {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        HashSet<Pair<Integer, Integer>> visited= new  HashSet<>();
        PriorityQueue<PNums> pq = new PriorityQueue<>((a, b) -> a.sum - b.sum);
        pq.add(new PNums(0, 0, nums1[0] + nums2[0]));
        while (!pq.isEmpty() && k > 0) {
            PNums q = pq.poll();
            --k;
            List<Integer> l = new ArrayList<>();
            l.add(q.num1idx);
            l.add(q.num2idx);
            res.add(l);
            if (q.num1idx + 1 < nums1.length && !visited.contains(new Pair<>(q.num1idx + 1,q.num2idx))){
                pq.add(new PNums(q.num1idx + 1, q.num2idx, nums1[q.num1idx + 1] + nums2[q.num2idx]));
                visited.add(new Pair<>(q.num1idx + 1,q.num2idx));
            }
            if (q.num2idx + 1 < nums1.length && !visited.contains(new Pair<>(q.num1idx,q.num2idx + 1))){
                pq.add(new PNums(q.num1idx, q.num2idx + 1, nums1[q.num1idx] + nums2[q.num2idx + 1]));
                visited.add(new Pair<>(q.num1idx,q.num2idx+1));
            }
        }
        return res;
    }
}
