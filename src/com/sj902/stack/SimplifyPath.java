package com.sj902.stack;

import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] strings = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String s : strings) {
            switch (s) {
                case "":
                case ".":
                    break;
                case "..":
                    if (!stack.isEmpty()) stack.pop();
                    break;
                default:
                    stack.push(s);
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.insert(0,"/"+stack.pop());
        }
        return sb.toString().equalsIgnoreCase()""?"/":sb.toString();
    }
}
