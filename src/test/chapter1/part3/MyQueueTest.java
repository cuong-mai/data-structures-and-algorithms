package chapter1.part3;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

public class MyQueueTest {

    private final String INPUT = "to be or not to - be - - that - - - is";

    @Test
    public void test() {
        MyQueue<String> queue = new MyQueue<>();

        String[] splitStrings = INPUT.split(" ");

        for (String s : splitStrings) {
            if (!s.equals("-")) {
                queue.enqueue(s);
            } else {
                String p = queue.dequeue();
                System.out.println(p);
            }
        }

        Assert.assertFalse(queue.isEmpty());
        Assert.assertEquals(2, queue.size());

        Iterator<String> iterator = queue.iterator();

        Assert.assertEquals("that", iterator.next());
        Assert.assertEquals("is", iterator.next());
    }
}
