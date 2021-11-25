package com.mycompany.testclass;

import com.mycompany.mylinkedlist.ILinkedList;
import com.mycompany.mylinkedlist.MyLinkedList;

import java.util.*;

// Данный класс не дает точных измерений времени, он не учитывает разогрев
// Измерения для отчета будут взяты поотдельности, множество отдельных мейнов
// в репозиторий не войдут

public class MainClass {

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        ILinkedList<Integer> myLinkedList = new MyLinkedList<>();

        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        Set<Integer> treeSet = new TreeSet<>();

        Map<Integer, Integer> hashMap = new HashMap<>();
        Map<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        Map<Integer, Integer> treeMap = new TreeMap<>();

        System.out.println("Testing lists: ");
        System.out.println("ArrayList: ");
        ITestClass arrListTestClass = new ListTestClass(arrayList);
        arrListTestClass.measureTime();
        arrListTestClass.printResults();

        System.out.println("LinkedList: ");
        ITestClass linkListTestClass = new ListTestClass(linkedList);
        linkListTestClass.measureTime();
        linkListTestClass.printResults();

        System.out.println("My List: ");
        ITestClass myListTestClass = new MyListTestClass(myLinkedList);
        myListTestClass.measureTime();
        myListTestClass.printResults();

        System.out.println("=============================");
        System.out.println("Testing sets");

        System.out.println("HashSet: ");
        ITestClass hashSetTestClass = new SetTestClass(hashSet);
        hashSetTestClass.measureTime();
        hashSetTestClass.printResults();

        System.out.println("LinkedHashSet: ");
        ITestClass linkedHashSetTestClass = new SetTestClass(linkedHashSet);
        linkedHashSetTestClass.measureTime();
        linkedHashSetTestClass.printResults();

        System.out.println("TreeSet: ");
        ITestClass treeSetTestClass = new SetTestClass(treeSet);
        treeSetTestClass.measureTime();
        treeSetTestClass.printResults();

        System.out.println("=============================");
        System.out.println("Testing maps");

        System.out.println("HashMap: ");
        ITestClass hashMapTestClass = new MapTestClass(hashMap);
        hashMapTestClass.measureTime();
        hashMapTestClass.printResults();

        System.out.println("LinkedHashMap: ");
        ITestClass linkedHashMapTestClass = new MapTestClass(linkedHashMap);
        linkedHashMapTestClass.measureTime();
        linkedHashMapTestClass.printResults();

        System.out.println("TreeMap:");
        ITestClass treeMapTestClass = new MapTestClass(treeMap);
        treeMapTestClass.measureTime();
        treeMapTestClass.printResults();
    }
}
