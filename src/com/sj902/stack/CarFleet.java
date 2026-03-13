package com.sj902.stack;

import java.util.Arrays;
import java.util.Stack;

class CarPair{
    int pos;
    int speed;

    public CarPair(int pos, int speed) {
        this.pos = pos;
        this.speed = speed;
    }
}

class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        CarPair[] cp = new CarPair[n];
        for (int i = 0; i < n; i++) {
            cp[i] = new CarPair(position[i], speed[i]);
        }
        Arrays.sort(cp, (a,b)-> b.pos-a.pos);
        Stack<Double> stack = new Stack<>();

        int res = 1;
        double max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            double time = ((target-cp[i].pos)/(double)cp[i].speed);
            System.out.println(time);
            if(stack.isEmpty()){
                stack.push(time);
                max = time;
            } else if(max<time){
                while(!stack.isEmpty()){
                    stack.pop();
                }
                stack.push(time);
                max = time;
                ++res;
            } else{
                stack.push(time);
            }
        }

        return res;
    }
}