package com.sj902.stringMatching;

public class RepeatedStringMatch {
    public int repeatedStringMatch(String a, String b) {
        int k = b.length()/a.length();
        int l = k+2;
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < k; j++) {
            sb = sb.append(a);
        }

        for(int i = k; i<=k+2;++i){
            if(sb.toString().contains(b)){
                return k-i;
            }
            sb.append(a);
        }
        return -1;
    }
}
