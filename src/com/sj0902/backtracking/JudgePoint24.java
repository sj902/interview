package com.sj0902.backtracking;

import java.util.ArrayList;
import java.util.List;

class JudgePoint24 {
    public boolean judgePoint24(int[] cards) {
        List<Double> list = new ArrayList<>();
        for (int card : cards) {
            list.add((double) card);
        }

        return checkIfResultReached(list);
    }

    private boolean checkIfResultReached(List<Double> list) {
        if (list.size() == 1) {
            return Math.abs(list.get(0) - 24.0) < 0.1;
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                List<Double> l = new ArrayList<>();
                for (int k = 0; k < list.size(); k++) {
                    if (k != i && k != j) {
                        l.add(list.get(k));
                    }
                }

                for (double d : getAll(list.get(i), list.get(j))) {
                    l.add(d);
                    if (checkIfResultReached(l)) {
                        return true;
                    }
                    l.remove(l.size() - 1);
                }

            }
        }

        return false;
    }

    private List<Double> getAll(Double a, Double b) {
        List<Double> l = new ArrayList<>();
        l.add(a+b);
        l.add(a-b);
        l.add(b-a);
        l.add(b*a);
        if(a!=0)l.add(b/a);
        if(b!=0)l.add(a/b);
        return l;
    }
}