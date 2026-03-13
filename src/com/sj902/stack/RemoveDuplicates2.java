package com.sj902.stack;

import java.util.Stack;


class Q{
    int count;
    char c;

    public Q(int count, char c) {
        this.count = count;
        this.c = c;
    }

    @Override
    public String toString() {
        return "Q{" +
                "count=" + count +
                ", c=" + c +
                '}';
    }
}

class RemoveDuplicates2 {
    public String removeDuplicates(String s, int k) {
        Stack<Q> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if(stack.isEmpty()){
                stack.push(new Q(1,c));
            } else if(stack.peek().c == c  && stack.peek().count<k){
                stack.push(new Q(stack.peek().count+1, c));
            } else{
                prune(stack, k);
                if(!stack.isEmpty() && stack.peek().c == c){
                    stack.push(new Q(stack.peek().count+1, c));
                } else{
                    stack.push(new Q(1, c));
                }
            }
        }
        prune(stack, k);
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop().c);
        }
        return sb.reverse().toString();
    }

    private void prune(Stack<Q> stack, int k) {
        if(stack.isEmpty())return;
        if(stack.peek().count<k) return;
        char c = stack.peek().c;
        int i = 0;

        while (!stack.isEmpty() && stack.peek().c == c && i<k){
            stack.pop();
            ++i;
        }
    }
}