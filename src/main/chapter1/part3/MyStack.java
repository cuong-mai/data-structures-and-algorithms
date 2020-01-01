package chapter1.part3;

import java.util.Iterator;

public class MyStack<T> implements Iterable<T> {

    private Node first;
    int size;

    public MyStack() {
        first = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void push (T item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        size++;
    }

    public T peek() {
        if (first != null) {
            return first.item;
        }
        return null;
    }

    public T pop() {
        if (first !=null) {
            T item = first.item;
            first = first.next;
            size--;
            return item;
        }
        return null;
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
