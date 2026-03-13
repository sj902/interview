package com.sj902.geometry;

import java.util.HashSet;
import java.util.Objects;

class P {
    int a;
    int b;

    public P(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof P)) return false;
        P p = (P) (o);
        return a == p.a && b == p.b;
    }
}

public class MinAreaRect {
    public int minAreaRect(int[][] points) {
        HashSet<P> set = new HashSet<>();
        for (int i = 0; i < points.length; i++) {
            set.add(new P(points[i][0], points[i][1]));
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                P a = new P(points[i][0], points[i][1]);
                P b = new P(points[j][0], points[j][1]);
                System.out.println(i+":"+j+":"+a.a+":"+a.b+":"+b.a+":"+b.b);
                if(a.a!=b.a && a.b!=b.b && set.contains(new P(points[i][0], points[j][1])) && set.contains(new P(points[j][0], points[i][1]))){
                    System.out.println("here");
                    res = Math.min(res, Math.abs(a.a - b.a) * Math.abs(a.b-b.b));
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
