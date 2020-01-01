package chapter1.part3.exercise4;

import org.junit.Assert;
import org.junit.Test;

public class ParenthesesTest {

    @Test
    public void test() {

        Assert.assertTrue(Parentheses.balanced("[()]{}{[()()]()}"));
        Assert.assertTrue(Parentheses.balanced("(((())))"));
        Assert.assertTrue(Parentheses.balanced("[][][]{{{}}}()[{{}(){}}]"));

        Assert.assertFalse(Parentheses.balanced("(((()))"));
        Assert.assertFalse(Parentheses.balanced("))))(((("));
        Assert.assertFalse(Parentheses.balanced("[(])"));
        Assert.assertFalse(Parentheses.balanced("][][][][]["));

    }
}
