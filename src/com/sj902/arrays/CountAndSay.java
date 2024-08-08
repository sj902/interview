package com.sj902.arrays;

public class CountAndSay {
    public String countAndSay(int n) {

    }

    public String countAndSayAux(int n) {
        if(n == 1) return "1";
        return RLE(countAndSayAux(n-1));
    }

    private String RLE(String s) {
        int i = 0;
        int j = 0;
        StringBuilder sb  = new StringBuilder();
        while (j<s.length()){
            char curr = s.charAt(j);
            int count = 0;
            while (j<s.length() && s.charAt(j)==curr){
                ++j;
                ++count;
            }
            sb.append(count);
            sb.append(curr);
        }
        return sb.toString();
    }

}
