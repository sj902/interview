package com.sj902.dp;

public class IsMatch {
    public boolean isMatch(String s, String p) {
        return aux(s, p);
    }

    private boolean aux(String s, String p) {
        System.out.println(s + "::" + p);
        if (p.length() == 0)
            return s.length() == 0;
        if (p.length() >= 2 && p.charAt(1) == '*') {
            boolean notTake = aux(s, p.substring(2));
            System.out.println("nottake" + "::" + notTake);
            boolean take = (s.length() > 0) && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')
                    && aux(s.substring(1), p);
            System.out.println("take" + "::" + take);

            return take || notTake;
        } else {
            return (s.length() > 0) && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && aux(s.substring(1), p.substring(1));
        }
    }
}
