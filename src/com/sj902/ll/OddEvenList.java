package com.sj902.ll;

public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if(head==null) return head;
        ListNode dummy = new ListNode(0, head);
        ListNode curr = head;
        ListNode prev = dummy;
        ListNode even = new ListNode();
        ListNode evenPrev = even;
        int i = 1;
        while (curr!=null){
            if(i%2 == 0){
                prev.next = curr.next;
                evenPrev.next = curr;
                evenPrev = evenPrev.next;
                curr = prev.next;
            }else{
                prev = curr;
                curr = curr.next;
            }
            ++i;
        }
        evenPrev.next = null;
        curr = head;
        while (curr.next!=null)curr = curr.next;
        curr.next = even.next;
        return dummy.next;
    }
}
