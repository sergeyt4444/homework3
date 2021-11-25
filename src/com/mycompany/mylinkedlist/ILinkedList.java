package com.mycompany.mylinkedlist;

public interface ILinkedList <T> extends Iterable<T>{
    public void add(T element);
    public void add(int index, T element);
    public void clear();
    public T get(int index);
    public int indexOf(T element);
    public T remove(int index);
    public T set(int index, T element);
    public int size();
    public String toString();
    public Object[] toArray();
    public T[] toArray(T[] a);
}
