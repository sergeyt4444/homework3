package com.mycompany.testclass;

import com.mycompany.mylinkedlist.ILinkedList;
import com.mycompany.mylinkedlist.MyLinkedList;

import java.util.*;

public class TempMain {
    public static void main(String[] args) {
        Map<Integer,Integer> list = new HashMap<>();
        ITestClass testClass = new MapTestClass(list);
        testClass.setN(75000);
        testClass.measureTime();
        testClass.printResults();
    }
}
