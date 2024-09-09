package com.sj902.ll;

public class SplitInParts {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int size = 0;
        ListNode curr = head;
        while (curr != null) {
            ++size;
            curr = curr.next;
        }
        int elems = size / k;
        int extra = size % k;

        ListNode[] res = new ListNode[k];
        curr = head;
        for (int i = 0; i < k; i++) {
            int possibleNodesInThisIndex = elems;
            if (extra > 0) {
                possibleNodesInThisIndex++;
                --extra;
            }
            int currSize = 0;
            ListNode prev = null;
            while (currSize < possibleNodesInThisIndex) {
                ++currSize;
                if (prev == null) {
                    res[i] = curr;
                } else {
                    prev.next = curr;
                }
                prev = curr;
                if (currSize == possibleNodesInThisIndex) {
                    ListNode temp = curr.next;
                    curr.next = null;
                    curr = temp;
                } else curr = curr.next;
            }
        }
        return res;
    }
}
