package com.sj902.dp;

public class NumDecodings {

    int[] res;

    public int numDecodings(String s) {
        res = new int[s.length()+1];
        for (int i = 0; i <= s.length(); i++) {
            res[i] = -1;
        }
        return numDecodingsAux(s, 0);
    }

    public int numDecodingsAux(String s, int i) {
        if (i == s.length()) return 1;
        if (i >= s.length()) return 0;
        if (s.charAt(i) == '0') return 0;
        if(res[i]!=-1) return res[i];

        int c = s.charAt(i);
        switch (c) {
            case '1':
                return numDecodingsAux(s, i + 1) + numDecodingsAux(s, i + 2);
            case '2':
                if (s.length() > i + 1 && (s.charAt(i + 1) == '7' || s.charAt(i + 1) == '8' || s.charAt(i + 1) == '9')) {
                    return numDecodingsAux(s, i + 1);
                }
                return numDecodingsAux(s, i + 1) + numDecodingsAux(s, i + 2);
            default:
                return numDecodingsAux(s, i + 1);
        }

    }
}
