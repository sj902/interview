package com.cses.sorting;

import java.util.HashSet;
import java.util.*;
import java.util.Scanner;

public class DistinctNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] ints = sc.nextLine().split(" ");
        Set<Integer> set = new HashSet<>();
        for(String j: ints) set.add(Integer.parseInt(j));
        System.out.println(set.size());
    }
}
