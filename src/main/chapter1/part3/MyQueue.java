package chapter1.part3;

import java.util.Iterator;

public class MyQueue<T> implements Iterable<T> {

    private Node first;
    private Node last;
    private int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(T item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if (oldLast != null) {
            oldLast.next = last;
        }
        size++;
        if (size <= 1) {
            first = last;
        }
    }

    public T dequeue() {
        if (first != null) {
            T item = first.item;
            first = first.next;
            size--;
            if (size <= 1) {
                last = first;
            }
            return item;
        } else {
            return null;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    class Node {
        T item;
        Node next;
    }

    class Itr implements Iterator<T> {

        Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }
    }
}
