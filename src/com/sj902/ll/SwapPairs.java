package com.sj902.ll;

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        dummy.next = head;
        ListNode curr = head;
        ListNode p = dummy;
        while(curr!=null){
            if(curr.next!=null){
                ListNode a = curr;
                ListNode b = curr.next;
                ListNode temp = b.next;
                p.next = b;
                b.next = a;
                a.next = temp;
                p = a;
            }
        }
        return dummy.next;
    }
}
