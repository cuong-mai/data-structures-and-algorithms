package chapter2.part5.exercise2;

import org.junit.Assert;
import org.junit.Test;

public class CompoundWordsTest {

    @Test
    public void test() {
        String[] words = {"in", "cat", "the", "hat", "thecat", "that", "inthe", "hatknows", "inthehat", "aboutthat", "about"};

        String[] expected = {"aboutthat", "inthe", "inthehat", "thecat"};
        Assert.assertArrayEquals(expected, CompoundWords.getCompoundWords(words));
    }
}
