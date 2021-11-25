package com.mycompany.testclass;

import java.util.Map;

public class MapTestClass implements ITestClass{

    private Map<Integer, Integer> testedMap;
    private long putTime;
    private long getTime;
    private long replaceTime;
    private long removeTime;
    private int n = 100000;

    public MapTestClass(Map<Integer, Integer> testedMap) {
        this.testedMap = testedMap;
    }

    public int getN() {
        return n;
    }

    public long getPutTime() {
        return putTime;
    }

    public void setPutTime(long putTime) {
        this.putTime = putTime;
    }

    public long getGetTime() {
        return getTime;
    }

    public void setGetTime(long getTime) {
        this.getTime = getTime;
    }

    public long getReplaceTime() {
        return replaceTime;
    }

    public void setReplaceTime(long replaceTime) {
        this.replaceTime = replaceTime;
    }

    public long getRemoveTime() {
        return removeTime;
    }

    public void setRemoveTime(long removeTime) {
        this.removeTime = removeTime;
    }

    public void setN(int n) {
        this.n = n;
    }

    @Override
    public void measureTime() {
        long startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            testedMap.put(i,i);
        }
        putTime = System.nanoTime() - startTime;
        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            testedMap.get(i);
        }
        getTime = System.nanoTime() - startTime;
        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            testedMap.replace(i, i + n);
        }
        replaceTime = System.nanoTime() - startTime;
        startTime = System.nanoTime();
        for (int i = 0; i <n; i++) {
            testedMap.remove(i);
        }
        removeTime = System.nanoTime() - startTime;

    }

    @Override
    public void printResults() {
        System.out.println("Time to put " + getN() + " elements: " + getPutTime());
        System.out.println("Time to get " + getN() + " elements: " + getGetTime());
        System.out.println("Time to replace" + getN() + " elements: " + getReplaceTime());
        System.out.println("Time to remove " + getN() + " elements: " + getRemoveTime());
    }
}
