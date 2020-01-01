package chapter1.part3;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

public class MyStackTest {

    private final String INPUT = "to be or not to - be - - that - - - is";

    @Test
    public void test() {
        MyStack<String> stack = new MyStack<>();

        String[] splitStrings = INPUT.split(" ");

        for (String s : splitStrings) {
            if (!s.equals("-")) {
                stack.push(s);
            } else {
                String p = stack.pop();
                System.out.println(p);
            }
        }

        Assert.assertFalse(stack.isEmpty());
        Assert.assertEquals(2, stack.size());

        Iterator<String> iterator = stack.iterator();

        Assert.assertEquals("is", iterator.next());
        Assert.assertEquals("to", iterator.next());
    }
}
