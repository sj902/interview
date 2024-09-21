package com.sj902.graph;

import java.util.ArrayList;
import java.util.List;

public class LexicalOrder {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();

        int i = 1;

        for (int j = 1; j <= n; j++) {
            res.add(i);
            if (i * 10 <= n) {
                i = i *10;
            } else {
                while (i%10 == 9 || i ==n){
                    i = i/10;
                }
                ++i;
            }
        }
        return res;
    }
}
