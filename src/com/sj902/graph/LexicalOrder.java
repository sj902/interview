package com.sj902.graph;

import java.util.ArrayList;
import java.util.List;

public class LexicalOrder {
    List<Integer> res;
    int max;
    public List<Integer> lexicalOrder(int n) {
        max = n;
        res = new ArrayList<>();
        aux("");
        return res;
    }

    void  aux(String curr){
        int c = Integer.parseInt(curr);
        if(c>max) return;
        if(c!=0){
            res.add(c);
        }
        for (int i = 0; i <= 9 ; i++) {
            aux(curr+i);
        }
    }
}
