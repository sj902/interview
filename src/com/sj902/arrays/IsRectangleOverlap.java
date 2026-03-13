package com.sj902.arrays;

public class IsRectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x1 = rec1[0];
        int y1 = rec1[1];
        int x2 = rec1[2];
        int y2 = rec1[3];

        int x12 = rec2[0];
        int y12 = rec2[1];
        int x22 = rec2[2];
        int y22 = rec2[3];

        boolean isLeft = x22 <= x1;
        boolean isRight = x12 >= x2;
        boolean isUp = y12 >=y2;
        boolean isDown  = y22<=y1;

        return isDown||isLeft||isRight||isUp;
    }
}
