package com.sj902.geometry;

public class AngleClock {
    public double angleClock(int hour, int minutes) {
        double minuteAngle = minutes * 6;
        double hourAngle = hour * 30;
        double hourAdjusted = minutes/2.0;
        double hourTotal = hourAngle+hourAdjusted;
        return Math.min(360-Math.abs(minuteAngle-hourTotal), Math.abs(minuteAngle-hourTotal));
    }
}
