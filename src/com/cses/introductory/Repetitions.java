//package com.cses.introductory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Repetitions {
    public static void main(String[] args) throws IOException {
        char[] ch = new BufferedReader(new InputStreamReader(System.in)).readLine().toCharArray();
        int res = 0;
        int cl = 0;
        char curr = '.';
        for (int i = 0; i < ch.length; i++) {
            if(ch[i] == curr){
                ++cl;
                res = Math.max(res, cl);
            } else {
                cl = 1;
                curr = ch[i];
                res = Math.max(res, cl);
            }
        }
        System.out.println(res);
    }
}
