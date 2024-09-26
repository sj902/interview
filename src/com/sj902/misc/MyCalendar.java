package com.sj902.misc;

import java.util.TreeMap;
class Sol1{
    public static void main(String[] args) {
        MyCalendar m = new MyCalendar();
        m.book(10,20);
        m.book(15,25);
        m.book(20,30);
    }
}


public class MyCalendar {
    TreeMap<Integer, Integer> map;
    public MyCalendar() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer lower = map.floorKey(start);
        System.out.println(lower);
        if(lower != null && map.get(lower)>=start){
            return false;
        }
        map.put(start, end);
        return true;
    }
}
