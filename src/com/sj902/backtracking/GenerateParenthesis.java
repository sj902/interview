package com.sj902.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();

        generateParenthesisAux(n, res, "", 0, 0);
        return res;
    }

    private void generateParenthesisAux(int n, ArrayList<String> res, String curr, int open, int closed) {
        if (open > n || closed > n) return;
        if (closed == n) {
            res.add(curr);
            return;
        }

        if (open == closed) {
            generateParenthesisAux(n, res, curr+"(", open + 1, closed);
        } else {
            generateParenthesisAux(n, res, curr+"(", open + 1, closed);
            generateParenthesisAux(n, res, curr+")", open , closed+1);
        }

    }


}
