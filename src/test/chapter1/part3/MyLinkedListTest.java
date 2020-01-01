package chapter1.part3;

import org.junit.Assert;
import org.junit.Test;

public class MyLinkedListTest {

    private final String STRING_TORONTO = "Toronto";
    private final String STRING_QUEBEC = "Quebec";
    private final String STRING_ALBERTA = "Alberta";

    @Test
    public void testAddFirst() {
        MyLinkedList<String> list = new MyLinkedList<>();

        list.addFirst(STRING_TORONTO);
        Assert.assertEquals(1, list.getSize());
        Assert.assertEquals(STRING_TORONTO, list.getFirst());
        Assert.assertEquals(STRING_TORONTO, list.getLast());

        list.addFirst(STRING_QUEBEC);
        Assert.assertEquals(2, list.getSize());
        Assert.assertEquals(STRING_QUEBEC, list.getFirst());
        Assert.assertEquals(STRING_TORONTO, list.getLast());

        list.addFirst(STRING_ALBERTA);
        Assert.assertEquals(3, list.getSize());
        Assert.assertEquals(STRING_ALBERTA, list.getFirst());
        Assert.assertEquals(STRING_TORONTO, list.getLast());
    }

    @Test
    public void testRemoveFirstWhenHavingThreeItems() {
        MyLinkedList<String> list = new MyLinkedList<>();

        list.addFirst(STRING_TORONTO);
        list.addFirst(STRING_QUEBEC);
        list.addFirst(STRING_ALBERTA);

        list.removeFirst();

        Assert.assertEquals(2, list.getSize());
        Assert.assertEquals(STRING_QUEBEC, list.getFirst());
        Assert.assertEquals(STRING_TORONTO, list.getLast());
    }

    @Test
    public void testRemoveFirstWhenHavingTwoItems() {
        MyLinkedList<String> list = new MyLinkedList<>();

        list.addFirst(STRING_TORONTO);
        list.addFirst(STRING_QUEBEC);

        list.removeFirst();

        Assert.assertEquals(1, list.getSize());
        Assert.assertEquals(STRING_TORONTO, list.getFirst());
        Assert.assertEquals(STRING_TORONTO, list.getLast());
    }

    @Test
    public void testRemoveFirstWhenHavingOneItem() {
        MyLinkedList<String> list = new MyLinkedList<>();

        list.addFirst(STRING_TORONTO);

        list.removeFirst();

        Assert.assertEquals(0, list.getSize());
        Assert.assertNull(list.getFirst());
        Assert.assertNull(list.getLast());
    }

    @Test
    public void testRemoveFirstWhenEmpty() {
        MyLinkedList<String> list = new MyLinkedList<>();

        list.removeFirst();

        Assert.assertEquals(0, list.getSize());
        Assert.assertNull(list.getFirst());
        Assert.assertNull(list.getLast());
    }


    @Test
    public void testAddLast() {
        MyLinkedList<String> list = new MyLinkedList<>();

        list.addLast(STRING_TORONTO);
        Assert.assertEquals(1, list.getSize());
        Assert.assertEquals(STRING_TORONTO, list.getFirst());
        Assert.assertEquals(STRING_TORONTO, list.getLast());

        list.addLast(STRING_QUEBEC);
        Assert.assertEquals(2, list.getSize());
        Assert.assertEquals(STRING_TORONTO, list.getFirst());
        Assert.assertEquals(STRING_QUEBEC, list.getLast());
    }


}
