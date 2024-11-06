package com.sj902;

public class CompressedString {
    public String compressedString(String word) {
        StringBuilder res = new StringBuilder();
        if(word.isEmpty()) return word;
        char first = word.charAt(0);
        int count = 1;
        char ch = word.charAt(0);
        for (int i = 1; i < word.length(); i++) {
             ch = word.charAt(i);
             if(ch != first || count == 9){
                 res.append(count);
                 res.append(first);
                 first = ch;
                 count  = 1;
             } else {
                 count ++;
             }
        }
        return res+""+count+ch;
    }
}
