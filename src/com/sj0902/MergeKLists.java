package com.sj0902;

import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    class P {
        int idx;
        int val;

        public P(int a, int b) {
            this.idx = a;
            this.val = b;
        }
    }

    public class MergeKLists {
        public ListNode mergeKLists(ListNode[] lists) {
            int n = lists.length;
            ListNode res = new ListNode();
            ListNode curr = res;
            PriorityQueue<P> pq = new PriorityQueue<P>(new Comparator<P>() {
                @Override
                public int compare(P o1, P o2) {
                    return (Integer.compare(o1.val, o2.val));
                }
            });

            for (int i = 0; i < n; i++) {
                if(lists[i]!=null){
                    pq.add(new P(i, lists[i].val));
                }
            }

            while (!pq.isEmpty()) {
                P current = pq.poll();
                ListNode newNode = new ListNode(current.val);
                lists[current.idx] = lists[current.idx].next;
                if (lists[current.idx] != null) {
                    pq.add(new P(current.idx, lists[current.idx].val));
                }
                curr.next = newNode;
                curr = newNode;
            }
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    curr.next = lists[i];
                }
            }
            return res.next;
        }
    }
}
