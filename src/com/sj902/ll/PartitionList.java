package com.sj902.ll;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
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
                curr = prev.next;
                evenPrev = evenPrev.next;
            }else{
                prev = curr;
                curr = curr.next;
            }
            ++i;
        }
        evenPrev.next = null;
        prev.next = even.next;
        return dummy.next;
    }
}
