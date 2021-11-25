package com.mycompany.testclass;


import java.util.Set;

public class SetTestClass implements ITestClass{

    private Set<Integer> testedSet;
    private long addTime;
    private long removeTime;
    private int n = 100000;

    public SetTestClass(Set<Integer> testedSet) {
        this.testedSet = testedSet;
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

    public void setAddTime(long addTime) {
        this.addTime = addTime;
    }

    public long getRemoveTime() {
        return removeTime;
    }

    public void setRemoveTime(long removeTime) {
        this.removeTime = removeTime;
    }

    @Override
    public void measureTime() {
        long startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            testedSet.add(i);
        }
        addTime = System.nanoTime() - startTime;
        startTime = System.nanoTime();
        for (int i = 0; i <n; i++) {
            testedSet.remove(i);
        }
        removeTime = System.nanoTime() - startTime;

    }

    @Override
    public void printResults() {
        System.out.println("Time to add " + getN() + " elements: " + getAddTime());
        System.out.println("Time to remove " + getN() + " elements: " + getRemoveTime());
    }
}
