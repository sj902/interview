package com.sj902.ll;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry  = 0;
        ListNode dummy = new ListNode();
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode c3 = dummy;
        while (c1!=null || c2!=null || carry!=0){
            int s = 0;
            if(c1!=null){
                s+= c1.val;
                c1 = c1.next;
            }
            if(c2!=null){
                s+= c2.val;
                c2 = c2.next;
            }
            s += carry;
            carry = s/10;
            s = s%10;
            ListNode n = new ListNode(s);
            c3.next = n;
            c3 = c3.next;
        }
        return dummy.next;
    }
}