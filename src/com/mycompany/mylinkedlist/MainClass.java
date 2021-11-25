package com.mycompany.mylinkedlist;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MainClass {

    public static void main(String[] args) {
        ILinkedList<Integer> myList = new MyLinkedList<>();
        List<Integer> list = new LinkedList<>();

        System.out.println("Testing size() method:");
        System.out.println(myList.size());

        System.out.println("Same with LinkedList: ");
        System.out.println(list.size());


        System.out.println("Testing add and toString methods");
        for (int i = 1; i < 10; i++) {
            myList.add(i+1);
        }
        myList.add(0,0);
        myList.add(1,1);
        myList.add(11,11);
        System.out.println(myList);

        System.out.println("Same with LinkedList: ");
        for (int i = 1; i < 10; i++) {
            list.add(i+1);
        }
        list.add(0,0);
        list.add(1,1);
        list.add(11,11);
        System.out.println(list);

        System.out.println("Testing toArray methods");
        Integer[] intArr = new Integer[15];
        System.out.println(Arrays.toString(myList.toArray()));
        System.out.println(Arrays.toString(myList.toArray(intArr)));

        System.out.println("Same with LinkedList: ");
        Integer[] intArr2 = new Integer[15];
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(Arrays.toString(list.toArray(intArr2)));

        System.out.println("Testing size() method:");
        System.out.println(myList.size());

        System.out.println("Same with LinkedList: ");
        System.out.println(list.size());

        System.out.println("Testing set methods");
        for (int i = 0; i < myList.size(); i++) {
            myList.set(i, 2*i);
        }
        System.out.println(myList);

        System.out.println("Same with LinkedList: ");
        for (int i = 0; i < list.size(); i++) {
            list.set(i, 2*i);
        }
        System.out.println(list);

        System.out.println("Testing indexOf method:");
        for (int i = 0; i < myList.size(); i++) {
            System.out.print(myList.indexOf(i*2) + ", ");
        }
        System.out.println("");

        System.out.println("Same with LinkedList: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.indexOf(i*2) + ", ");
        }
        System.out.println("");

        System.out.println("Testing remove method:");
        myList.remove(0);
        myList.remove(myList.size() - 1);
        myList.remove(myList.size()/2);
        System.out.println(myList);

        System.out.println("Same with LinkedList: ");
        list.remove(0);
        list.remove(list.size() - 1);
        list.remove(list.size()/2);
        System.out.println(list);

        System.out.println("Testing clear method:");
        myList.clear();
        System.out.println(myList);

        System.out.println("Same with LinkedList: ");
        list.clear();
        System.out.println(list);

        System.out.println("Сравнение производительности в другом пакете");


    }

}
