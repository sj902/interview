package com.sj902.arrays;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(solve(100));
    }
    public static String solve(int A) {
        double res = 1;
        for(int i = 2;i<=A;++i){
            res = res * i;
            System.out.println(i+"\t"+res);
        }
        return res+"";
    }
}
