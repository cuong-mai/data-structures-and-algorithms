package chapter1.part3.exercise9;

import org.junit.Assert;
import org.junit.Test;

public class NoLeftParenthesesToInfixTest {

    @Test
    public void test() {
        Assert.assertEquals("((1+2)*((3-4)*(5-6)))", NoLeftParenthesesToInfix.convert("1+2)*3-4)*5-6)))"));
    }
}
