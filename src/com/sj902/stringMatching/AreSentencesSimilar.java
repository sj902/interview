package com.sj902.stringMatching;

public class AreSentencesSimilar {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (sentence2.length() > sentence1.length()) return false;
        if (sentence2.length() == 0) return true;
        int pre = getCommonPrefix(sentence1, sentence2 + " ");
        if (pre != -1 && sentence1.charAt(pre) != ' ') return false;
        int suffix = getCommonSuffix(sentence1, " " + sentence2);
        return suffix == -1 || sentence1.charAt(suffix) == ' ';
    }

    private int getCommonSuffix(String sentence1, String sentence2) {
        int i = sentence1.length()-1;
        int j = sentence2.length()-1;
        if (sentence2.charAt(j) != sentence1.charAt(i)) return -1;

        while (i>=0 && j>=0 && sentence2.charAt(j) == sentence1.charAt(i)) {
            --i; --j;
        }

        return i;
    }

    private int getCommonPrefix(String sentence1, String sentence2) {
        if (sentence2.charAt(0) != sentence1.charAt(0)) return -1;
        int res = 0;

        while (res < sentence2.length() && sentence2.charAt(res) == sentence1.charAt(res)) {
            ++res;
        }

        return res;
    }
}
