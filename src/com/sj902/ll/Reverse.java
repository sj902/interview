package com.sj902.ll;

public class Reverse {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode p = head;
        while (curr!=null){
            ListNode n = curr.next;
            curr.next = p;
            p = curr;
            curr = n;
        }
        return p;
    }
}
