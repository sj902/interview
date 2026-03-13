package com.sj902.ll;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

public class NestedIterator implements Iterator<Integer> {
    int i;
    List<Integer> list;

    public NestedIterator(List<NestedInteger> nestedList) {
        list = new ArrayList<>();
        i = 0;
        for(NestedInteger ni: nestedList){
            addToList(ni);
        }
    }

    private void addToList(NestedInteger ni) {
        if(ni.isInteger()){
            list.add(ni.getInteger());
            return;
        }
        List<NestedInteger> nil = ni.getList();
        for(NestedInteger n: nil){
            addToList(n);
        }
    }

    @Override
    public Integer next() {
        return list.get(i++);
    }

    @Override
    public boolean hasNext() {
        return i < list.size();
    }
}
