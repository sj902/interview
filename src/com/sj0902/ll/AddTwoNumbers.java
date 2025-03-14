package com.sj0902.ll;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode temp = res;
        int c = 0;

        while (l1!=null || l2!=null){
            int f = 0;
            int s = 0;
            if(l1!=null) {
                f = l1.val;
                l1 = l1.next;
            }
            if(l2!=null) {
                s = l2.val;
                l2 = l2.next;
            }
            int r = f+s+c;
            temp.next = new ListNode(r%10);
            c = r/10;
            temp = temp.next;
        }
        if(c>0){
            temp.next = new ListNode(c);
        }
        return res.next;
    }
}
