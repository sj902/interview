package com.sj902.ll;

import java.util.*;

public class NextLargerNodes {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> values = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        ListNode curr = head;
        while (curr != null) {
            values.add(curr.val);
            curr = curr.next;
        }

        int[] res = new int[values.size()];
        int i = 0;

        for (int j = values.size()-1; j >=0; j--) {
            if(stack.isEmpty()){
                res[j] = 0;
                stack.push(values.get(j));
            } else if(stack.peek()>values.get(j)){
                res[j] = stack.peek();
                stack.push(values.get(j));
            } else {
                while (!stack.isEmpty() && stack.peek()<=values.get(j)){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    res[j] = 0;
                    stack.push(values.get(j));
                } else {
                    res[j] = stack.peek();
                    stack.push(values.get(j));
                }
            }
        }
        return (res);
    }
}
