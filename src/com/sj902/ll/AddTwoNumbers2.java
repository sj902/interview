package com.sj902.ll;

class Q{
    ListNode l;
    int carry;

    public Q(ListNode l, int carry) {
        this.l = l;
        this.carry = carry;
    }
}

public class AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int s1 = 0;
        ListNode c1 = l1;
        while (c1!=null) {
            ++s1;
            c1 = c1.next;
        }
        int s2 = 0;
        ListNode c2 = l2;
        while (c2!=null) {
            ++s2;
            c2 = c2.next;
        }
        if(s1>s2){
            l2 = addZero(l2, s1-s2);
        }
        if(s2>s1){
            l1 = addZero(l1, s2-s1);
        }

        c1 = l1;
        c2 = l2;
        ListNode n =  sum(c1, c2).l;
        if(n.val == 0) return n.next;
        return n;
    }

    private Q sum(ListNode c1, ListNode c2) {
        if(c1.next == null) {
            int a = c1.val+c2.val;
            return new Q(new ListNode(a%10), a/10);
        }
        ListNode n = new ListNode();
        Q w = sum(c1.next, c2.next);
        n.next = w.l;
        n.val = (c1.val+c2.val+w.carry)%10;
        return new Q(n, (c1.val+c2.val+w.carry)/10);
    }

    private ListNode addZero(ListNode l1, int i) {
        if(i == 0)return l1;
        return addZero(new ListNode(0, l1), i-1);
    }
}