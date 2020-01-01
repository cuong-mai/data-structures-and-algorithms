package chapter1.part3;

public class MyLinkedList<T> {

    private Node first;
    private Node last;
    private int size;

    public MyLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    private class Node {
        T item;
        Node next;
        Node() {
            item = null;
            next = null;
        }
    }

    public int getSize() {
        return size;
    }

    public T getFirst() {
        return first == null ? null : first.item;
    }

    public void addFirst(T item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        size++;
        if (size <= 1) {
            last = first;
        }
    }

    public void removeFirst() {
        if (first != null) {
            first = first.next;
            size--;
            if (size <= 1) {
                last = first;
            }
        }
    }

    public T getLast() {
        return last == null ? null : last.item;
    }

    public void addLast(T item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if (oldLast != null) {
            oldLast.next = last;
        }
        size++;
        if (size <=1) {
            first = last;
        }
    }

    public void removeLast() {

    }
}
