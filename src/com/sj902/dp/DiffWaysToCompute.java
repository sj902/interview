package com.sj902.dp;

import java.util.ArrayList;
import java.util.List;

public class DiffWaysToCompute {
    public List<Integer> diffWaysToCompute(String expression) {
        if (isNumber(expression)) {
            List<Integer> res = new ArrayList<>();
            res.add(Integer.parseInt(expression));
            return res;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < expression.length(); i++) {
            if (expression.charAt(i) == '*' || expression.charAt(i) == '+' || expression.charAt(i) == '-'){
                List<Integer> left = diffWaysToCompute(expression.substring(0, i+1));
                List<Integer> right = diffWaysToCompute(expression.substring(i+1, expression.length()));
                for(int l: left){
                    for(int r: right){
                        if(expression.charAt(i) == '*'){
                            res.add(l*r);
                        } else if(expression.charAt(i) == '+'){
                            res.add(l+r);
                        } else {
                            res.add(l-r);
                        }
                    }
                }
            }
        }
        return res;
    }

    private boolean isNumber(String expression) {
        for (int i = 1; i < expression.length(); i++) {
            if (expression.charAt(i) == '*' || expression.charAt(i) == '+' || expression.charAt(i) == '-')
                return false;
        }
        return true;
    }
}
