package com.sj902.arrays;

public class MultiplyString {
    public String multiply(String num1, String num2) {
        Double res = new Double(0);
        for (int i = num1.length()-1; i >=0; i--) {
            for (int j = num2.length()-1; j >=0; j--){
                int a = (int)(num1.charAt(i)-'0');
                int b = (int)(num2.charAt(j)-'0');
                res = res + (a*b*Math.pow(10,i+j));
            }
        }
        return res.toString();
    }
}
