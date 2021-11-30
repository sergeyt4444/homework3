package com.mycompany.mylinkedlist;


import java.util.Iterator;
import java.util.LinkedList;

public class MyLinkedList <T> implements ILinkedList<T>{

    private int size;
    private Node<T> first, last;

    @Override
    public void add(T element) {
        addLast(element);
    }

    private void addFirst(T element) {
        Node<T> tmpNode = new Node<>();
        tmpNode.element = element;
        if (last == null) {
            last = tmpNode;
        }
        else {
            tmpNode.nextNode = first;
            first.prevNode = tmpNode;
        }
        first = tmpNode;
        size++;
    }

    private void addLast(T element) {
        Node<T> tmpNode = new Node<>();
        tmpNode.element = element;
        if (first == null) {
            first = tmpNode;
        }
        else {
            tmpNode.prevNode = last;
            last.nextNode = tmpNode;
        }
        last = tmpNode;
        size++;
    }

    private void addMiddle(int index, T element) {
        Node<T> cur = first;
        for (int i = 0; i < index - 1; i++)
        {
            cur = cur.nextNode;
        }
        Node<T> tmpNode = new Node<>();
        tmpNode.element = element;
        tmpNode.prevNode = cur;
        tmpNode.nextNode = cur.nextNode;
        cur.nextNode.prevNode = tmpNode;
        cur.nextNode = tmpNode;
        size++;
    }

    @Override
    public void add(int index, T element) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            addFirst(element);
        }
        else {
            if (index == size) {
                addLast(element);
            }
            else {
                addMiddle(index, element);
            }
        }
    }

    private T removeFirst() {
        T tmp = first.element;
        if (size == 1) {
            first = last = null;
        }
        else {
            first.nextNode.prevNode = null;
            first = first.nextNode;
        }
        size--;
        return tmp;
    }

    private T removeLast() {
        T tmp = last.element;
        if (size == 1) {
            first = last = null;
        }
        else {
            last.prevNode.nextNode = null;
            last = last.prevNode;
        }
        size--;
        return tmp;
    }

    private T removeMiddle(int index) {
        Node<T> cur = first;
        for (int i = 0; i < index; i++)
        {
            cur = cur.nextNode;
        }
        cur.prevNode.nextNode = cur.nextNode;
        cur.nextNode.prevNode = cur.prevNode;
        cur.nextNode = null;
        cur.prevNode = null;
        size--;
        return cur.element;
    }

    @Override
    public T remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        T tmp;
        if (index == 0) {
            tmp = removeFirst();
        }
        else {
            if (index == size - 1) {
                tmp = removeLast();
            }
            else {
                tmp = removeMiddle(index);
            }
        }
        return tmp;
    }

    @Override
    public void clear() {
        for (Node<T> x = first; x != null; ) {
            Node<T> next = x.nextNode;
            x.element = null;
            x.nextNode = null;
            x.prevNode = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }

    @Override
    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> cur;
        if (index < size/2) {
            cur = first;
            for (int i = 0; i < index; i++) {
                cur = cur.nextNode;
            }
        }
        else {
            cur = last;
            for (int i = size-1; i > index; i--) {
                cur = cur.prevNode;
            }
        }
        return cur.element;
    }

    @Override
    public int indexOf(T element) {
        int index = 0;
        Node<T> curNode = first;
        if (element == null) {
            for (index = 0; index < size; index++) {
                if (curNode.element == null) {
                    return index;
                }
                curNode = curNode.nextNode;
            }
        } else {
            for (index = 0; index < size; index++) {
                if (curNode.element.equals(element)) {
                    return index;
                }
                curNode = curNode.nextNode;
            }
        }
        return -1;
    }

    @Override
    public T set(int index, T element) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> cur;
        if (index < size/2) {
            cur = first;
            for (int i = 0; i < index; i++) {
                cur = cur.nextNode;
            }
        }
        else {
            cur = last;
            for (int i = size-1; i > index; i--) {
                cur = cur.prevNode;
            }
        }
        T tmp = cur.element;
        cur.element = element;
        return tmp;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        int i = 0;
        for(Iterator<T> item = iterator(); item.hasNext(); ) {
            arr[i] = item.next();
            i++;
        }
        return arr;

    }

    @Override
    public T[] toArray(T[] a) {
        if (a.length < size)
            a = (T[])java.lang.reflect.Array.newInstance(
                    a.getClass().getComponentType(), size);
        int i = 0;
        for(Iterator<T> item = iterator(); item.hasNext(); ) {
            a[i] = item.next();
            i++;
        }
        if (a.length > size)
        {
            a[size] = null;
        }
        return a;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private MyLinkedList.Node<T> next;
            private int nextInd;

            {
                next = first;
                nextInd = 1;
            }

            @Override
            public boolean hasNext() {
                return nextInd <= size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    return null;
                }
                nextInd++;
                T tmp = next.element;
                next = next.nextNode;
                return tmp;
            }
        };
    }


    private static class Node<T> {
        private T element;
        private Node<T> nextNode;
        private Node<T> prevNode;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        if (size > 0) {
            Iterator<T> item = this.iterator();
            stringBuilder.append(item.next());
            while (item.hasNext())
            {
                stringBuilder.append(", " + item.next());
            }
        }
        stringBuilder.append("]");

        return stringBuilder.toString();
    }

}
