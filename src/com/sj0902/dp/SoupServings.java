package com.sj0902.dp;

import java.util.HashMap;

public class SoupServings {
    HashMap<Integer,HashMap<Integer, Double>> dp;
    public double soupServings(int n) {
        int k = (int) Math.ceil(n/25.0);
        dp = new HashMap<>();
        return aux(k, k);
    }

    private double aux(int a, int b) {
        if (a <= 0 && b > 0) return 1;
        if (a <= 0) return 0.5;
        if (b <= 0) return 0;
        if(dp.getOrDefault(a, new HashMap<>()).containsKey(b))return dp.get(a).get(b);
        double res =
                aux(a - 4, b) +
                        aux(a - 3, b - 1) +
                        aux(a - 2, b - 2) +
                        aux(a - 1, b - 3);
        HashMap<Integer, Double> map = dp.getOrDefault(a, new HashMap<>());
        map.put(b, res/4);
        dp.put(a, map);
        return res / 4;
    }
}
