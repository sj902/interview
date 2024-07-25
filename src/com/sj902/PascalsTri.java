package com.sj902;

import java.util.ArrayList;
import java.util.List;

public class PascalsTri {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> first = new ArrayList<>();
        first.add(1);
        res.add(first);
        if (numRows == 1)
            return res;
        ArrayList<Integer> second = new ArrayList<>();
        second.add(1);
        second.add(1);
        res.add(second);
        if (numRows == 2)
            return res;


        for(int i = 2; i<numRows; ++i){
            ArrayList<Integer> newLine = new ArrayList<>();
            newLine.add(1);
            for(int j = 1; j<i-1; ++j){
                newLine.add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
            }
            newLine.add(1);
            res.add(newLine);
        }

        return res;
    }
}
