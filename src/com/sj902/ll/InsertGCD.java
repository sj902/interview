package com.sj902.ll;

public class InsertGCD {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode curr = head;
        ListNode thisNode = curr;
        while (curr.next != null) {
            ListNode nextNode = curr.next;
            int gcd = gcd(thisNode.val, nextNode.val);
            ListNode mid = new ListNode(gcd);
            thisNode.next = mid;
            mid.next = nextNode;
            curr = nextNode;
            thisNode = curr;
        }
        return head;
    }


    private int gcd(int a, int b) {
        if(a == 1 || b==1){
            return 1;
        }
        while(b !=0){
            int rem = a % b;
            a = b;
            b= rem;
        }
        return a;
    }
}
