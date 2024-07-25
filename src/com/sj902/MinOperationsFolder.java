package com.sj902;

public class MinOperationsFolder {
    public int minOperations(String[] logs) {
        int res = 0;
        for (String s : logs) {
            if(s.equalsIgnoreCase("../")){
                res = Math.max(res-1, 0);
            } else if (s.equalsIgnoreCase("./")) {
                res = res;
            } else{
                res ++;
            }
        }
        return res;
    }
}
