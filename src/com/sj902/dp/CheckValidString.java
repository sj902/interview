package com.sj902.dp;

public class CheckValidString {
    public static void main(String[] args) {
        System.out.println(checkValidString("("));
    }

    static Boolean[][] b;

    static public boolean checkValidString(String s) {
        b = new Boolean[s.length()][s.length()];
        return aux(s, 0, 0);
    }

    static private boolean aux(String s, int start, int i) {
        if(i<0) return false;
        if (start == s.length()) return i == 0;
        if (b[start][i] != null) return b[start][i];
        char c = s.charAt(start);
        switch (c) {
            case '(':
                return b[start][i] = aux(s, start + 1, i + 1);
            case ')':
                --i;
                if (i < 0) return false;
                return b[start][i] = aux(s, start + 1, i);
            case '*':
                return b[start][i] = aux(s, start + 1, i) || aux(s, start + 1, i + 1) || aux(s, start + 1, i - 1);
        }
        return false;
    }
}
