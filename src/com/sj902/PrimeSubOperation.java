package com.sj902;

import java.util.ArrayList;
import java.util.Arrays;

public class PrimeSubOperation {
    public boolean primeSubOperation(int[] nums) {
        ArrayList<Integer> primes = new ArrayList<>();
        primes.add(1);
        primes.add(2);

        for (int i = 3; i <= 1000; i++) {
            boolean flag = false;
            for (double j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                primes.add(i);
            }
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            int first = nums[i+1];
            int second = nums[i];
            int newSecond = getNewSecond(first, second, primes);
            System.out.println(newSecond);
            nums[i] = newSecond;
            if(newSecond>=first){
                return false;
            }
        }

        return true;
    }

    private int getNewSecond(int first, int second, ArrayList<Integer> primes) {
        if(second<first)return second;
        int i = primes.size()-1;

        int res = second;

        while (i>=0){
            if(second == 20){
                System.out.println(second+"::"+primes.get(i)+"::"+first +"::"+(second-primes.get(i)<first)+"::"+(second-primes.get(i)));
            }

            if(second-primes.get(i)<first && second-primes.get(i)>0){
                res = second-primes.get(i);
            }
            --i;
        }
        return res;
    }
}
