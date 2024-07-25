package com.sj902.stack;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {

    }

    public static String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {

            if (c == ']') {
                String a = "";
                while (stack.peek() != '[') {
                    char top = stack.pop();
                    a = top + a;
                }
                stack.pop();
                String countStr = "";
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    char top = stack.pop();
                    countStr = top + countStr;
                }
                int count = Integer.parseInt(countStr);
                StringBuilder tmp = new StringBuilder();
                for (int i = 0; i < count; i++) {
                    tmp.append(a);
                }
                for (char p : tmp.toString().toCharArray()) {

                    stack.push(p);
                }
            } else {
                stack.push(c);
            }
        }

        while (!stack.isEmpty()){
            res.append(stack.pop());
        }

        return res.reverse().toString();
    }
}
