package com.sj902.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinations {
    HashMap<Integer, ArrayList<String>> map;

    public List<String> letterCombinations(String digits) {
        map = new HashMap<Integer, ArrayList<String>>();
        ArrayList<String> a2 = new ArrayList<String>();
        a2.add("a");
        a2.add("b");
        a2.add("c");

        map.put(2, a2);
        ArrayList<String> a3 = new ArrayList<String>();
        a3.add("d");
        a3.add("e");
        a3.add("f");

        map.put(3, a3);
        ArrayList<String> a4 = new ArrayList<String>();
        a4.add("g");
        a4.add("h");
        a4.add("i");

        map.put(4, a4);
        ArrayList<String> a5 = new ArrayList<String>();
        a5.add("j");
        a5.add("k");
        a5.add("l");

        map.put(5, a5);
        ArrayList<String> a6 = new ArrayList<String>();
        a6.add("m");
        a6.add("n");
        a6.add("o");

        map.put(6, a6);
        ArrayList<String> a7 = new ArrayList<String>();
        a7.add("p");
        a7.add("q");
        a7.add("r");
        a7.add("s");

        map.put(7, a7);
        ArrayList<String> a8 = new ArrayList<String>();
        a8.add("t");
        a8.add("u");
        a8.add("v");

        map.put(8, a8);
        ArrayList<String> a9 = new ArrayList<String>();
        a9.add("w");
        a9.add("x");
        a9.add("y");
        a9.add("z");

        map.put(9, a9);


        ArrayList<String> res = new ArrayList<>();
        letterCombinationsAux(digits, 0, res, "");
        return res;
    }

    private void letterCombinationsAux(String digits, int i, ArrayList<String> res, String s) {
        if(i>=digits.length()-1) res.add(s);

        int c = Integer.parseInt(digits.charAt(i)+"");
        ArrayList<String> a = map.get(c);

        for (int j = 0; j < a.size(); j++) {
            letterCombinationsAux(digits, i+1, res, s+a.get(j));
        }
    }
}
