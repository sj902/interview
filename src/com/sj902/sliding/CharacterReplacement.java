package com.sj902.sliding;

import java.util.HashMap;

public class CharacterReplacement {

    public static void main(String[] args) {
        System.out.println(characterReplacement("KRSCDCSONAJNHLBMDQGIFCPEKPOHQIHLTDIQGEKLRLCQNBOHNDQGHJPNDQPERNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF", 4));
    }

    public static int characterReplacement(String s, int k) {
        String alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int res = 0;
        for (int i = 0; i < 26; i++) {
            char c = alph.charAt(i);
            int tmp = characterReplacementAux(s, k, c);
            res = Math.max(res, tmp);
        }
        return res;
    }

    public static int characterReplacementAux(String s, int k, char z) {
        HashMap<Character, Integer> map = new HashMap<>();
        int begin = 0;
        int end = 0;
        int res = 0;
        int counter = 0;

        while (end < s.length()) {
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (c != z) counter++;
            ++end;
            while (counter > k) {
                char q = s.charAt(begin);
                if (q != z) {
                    map.put(q, map.getOrDefault(q, 0) - 1);
                        counter--;
                }
                ++begin;
            }
            if (end - begin > 1) {
                System.out.println(s.substring(begin, end) + ":::" + z+":::" + k+":::" + counter);
            }
            res = Math.max(res, end - begin);

        }
        return res;
    }

}
