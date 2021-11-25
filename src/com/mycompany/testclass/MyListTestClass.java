package com.mycompany.testclass;

import com.mycompany.mylinkedlist.ILinkedList;

import java.util.List;

public class MyListTestClass implements ITestClass{

    private ILinkedList<Integer> testedList;
    private long addTime;
    private long removeTime;
    private long getTime;
    private long setTime;
    private int n = 100000;

    public MyListTestClass(ILinkedList<Integer> testedList) {
        this.testedList = testedList;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public long getAddTime() {
        return addTime;
    }

    public long getRemoveTime() {
        return removeTime;
    }

    public long getGetTime() {
        return getTime;
    }

    public long getSetTime() {
        return setTime;
    }

    public void measureTime() {
        long startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            testedList.add(i);
        }
        addTime = System.nanoTime() - startTime;
        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            testedList.get(i);
        }
        getTime = System.nanoTime() - startTime;
        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            testedList.set(i, i*2);
        }
        setTime = System.nanoTime() - startTime;
        startTime = System.nanoTime();
        for (int i = 0; i <n; i++) {
            testedList.remove(testedList.size()-1);
        }
        removeTime = System.nanoTime() - startTime;
    }

    public void printResults() {
        System.out.println("Time to add " + getN() + " elements: " + getAddTime());
        System.out.println("Time to get " + getN() + " elements: " + getGetTime());
        System.out.println("Time to set " + getN() + " elements: " + getSetTime());
        System.out.println("Time to remove " + getN() + " elements: " + getRemoveTime());
    }

}
